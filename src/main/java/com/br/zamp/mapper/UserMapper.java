package com.br.zamp.mapper;

import com.br.zamp.domain.User;
import com.br.zamp.dto.CreateUserDTO;
import com.br.zamp.dto.ReadAndUpdateUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, CreateUserDTO, ReadAndUpdateUserDTO> {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
