package com.br.zamp.mapper;

import com.br.zamp.domain.Account;
import com.br.zamp.dto.account.CreateAccountDTO;
import com.br.zamp.dto.account.ReadAndUpdateAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, CreateAccountDTO, ReadAndUpdateAccountDTO> {
  AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
}