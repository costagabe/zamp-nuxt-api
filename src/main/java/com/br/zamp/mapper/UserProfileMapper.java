package com.br.zamp.mapper;

import com.br.zamp.domain.UserProfile;
import com.br.zamp.dto.profile.CreateUserProfileDTO;
import com.br.zamp.dto.profile.ReadAndUpdateUserProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class UserProfileMapper
    implements BaseMapper<UserProfile, CreateUserProfileDTO, ReadAndUpdateUserProfileDTO> {
  @Override
  public ReadAndUpdateUserProfileDTO toReadAndUpdateDTO(UserProfile profile) {

    return new ReadAndUpdateUserProfileDTO(
        profile.getId(),
        profile.getOriginalName(),
        profile.getLevel(),
        profile.getPermissions().stream()
            .map(Enum::toString)
            .collect(java.util.stream.Collectors.toSet()));
  }
}
