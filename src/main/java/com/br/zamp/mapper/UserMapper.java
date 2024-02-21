package com.br.zamp.mapper;

import com.br.zamp.domain.Base;
import com.br.zamp.domain.User;
import com.br.zamp.domain.UserProfile;
import com.br.zamp.domain.enums.UserSituation;
import com.br.zamp.dto.user.CreateUserDTO;
import com.br.zamp.dto.user.ReadAndUpdateUserDTO;
import com.br.zamp.service.UserProfileService;
import com.br.zamp.service.UserService;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseMapper<User, CreateUserDTO, ReadAndUpdateUserDTO> {

  @Setter(onMethod_ = @Autowired)
  PasswordEncoder passwordEncoder;

  @Setter(onMethod_ = @Autowired)
  UserProfileService userProfileService;

  @Setter(onMethod_ = @Autowired)
  UserService userService;

  @Override
  public User createDTOToEntity(CreateUserDTO dto) {
    User user = createUserWithProfile(dto.profileIds());

    user.setName(dto.name());
    user.setEmail(dto.email());
    user.setPassword(passwordEncoder.encode("123456"));
    user.setSituation(UserSituation.ACTIVE);

    return user;
  }

  @Override
  public User readAndUpdateDTOToEntity(ReadAndUpdateUserDTO dto, UUID uuid) {
    Set<UserProfile> profiles = userProfileService.findByIdIn(dto.profileIds());
    User user = userService.findById(uuid);

    toEntity(dto, user);

    user.setUserProfiles(profiles);

    return user;
  }

  @Override
  public ReadAndUpdateUserDTO toReadAndUpdateDTO(User user) {
    Set<UUID> ids = user
      .getUserProfiles()
      .stream()
      .map(Base::getId)
      .collect(Collectors.toSet());

    return new ReadAndUpdateUserDTO(
      user.getId(),
      user.getName(),
      user.getEmail(),
      user.getSituation(),
      ids,
      user.getMaxUserProfileLevel().getName()
    );

  }

  private User createUserWithProfile(Set<UUID> profileIds) {
    Set<UserProfile> profiles = userProfileService.findByIdIn(profileIds);

    User user = new User();
    user.setUserProfiles(profiles);

    return user;
  }

}
