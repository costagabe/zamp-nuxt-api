package com.br.zamp.mapper;

import com.br.zamp.domain.User;
import com.br.zamp.domain.enums.UserSituation;
import com.br.zamp.dto.user.CreateUserDTO;
import com.br.zamp.dto.user.ReadAndUpdateUserDTO;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseMapper<User, CreateUserDTO, ReadAndUpdateUserDTO> {
//  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Setter(onMethod_ = @Autowired)
  PasswordEncoder passwordEncoder;

  @Override
   public User createDTOToEntity(CreateUserDTO dto) {
    User user = new User();

    user.setName(dto.name());
    user.setEmail(dto.email());
    user.setPassword(passwordEncoder.encode(dto.password()));
    user.setSituation(UserSituation.ACTIVE);

    return user;
  }
}
