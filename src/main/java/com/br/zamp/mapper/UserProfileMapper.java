package com.br.zamp.mapper;

import com.br.zamp.domain.UserProfile;
import com.br.zamp.dto.profile.CreateUserProfileDTO;
import com.br.zamp.dto.profile.ReadAndUpdateUserProfileDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserProfileMapper implements BaseMapper<UserProfile, CreateUserProfileDTO, ReadAndUpdateUserProfileDTO> {
    @Override
    public ReadAndUpdateUserProfileDTO toReadAndUpdateDTO(UserProfile profile) {

        return new ReadAndUpdateUserProfileDTO(
                profile.getId(),
                profile.getOriginalName(),
                profile.getLevel()
        );
    }
}
