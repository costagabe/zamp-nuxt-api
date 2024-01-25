package com.br.zamp.mapper;

import com.br.zamp.domain.UserProfile;
import com.br.zamp.dto.profile.CreateUserProfileDTO;
import com.br.zamp.dto.profile.ReadAndUpdateUserProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserProfileMapper extends BaseMapper<UserProfile, CreateUserProfileDTO, ReadAndUpdateUserProfileDTO> {
  UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);
}
