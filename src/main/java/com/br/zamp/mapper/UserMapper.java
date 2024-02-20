package com.br.zamp.mapper;

import com.br.zamp.domain.User;
import com.br.zamp.domain.UserProfile;
import com.br.zamp.domain.enums.UserSituation;
import com.br.zamp.dto.user.CreateUserDTO;
import com.br.zamp.dto.user.ReadAndUpdateUserDTO;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.UserProfileRepository;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseMapper<User, CreateUserDTO, ReadAndUpdateUserDTO> {

  @Setter(onMethod_ = @Autowired)
  PasswordEncoder passwordEncoder;

  @Setter(onMethod_ = @Autowired)
  UserProfileRepository profileRepository;

  @Override
  public User createDTOToEntity(CreateUserDTO dto) {
    UserProfile profile = profileRepository.findById(dto.profileId())
      .orElseThrow(() -> new ObjectNotFoundException("Erro ao encontrar perfil.", "profileId", "Perfil não encontrado."));

    User user = new User();

    user.setName(dto.name());
    user.setEmail(dto.email());
    user.setPassword(passwordEncoder.encode("123456"));
    user.setSituation(UserSituation.ACTIVE);
    user.setUserProfiles(Set.of(profile));

    return user;
  }
}
