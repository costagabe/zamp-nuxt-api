package com.br.zamp.mapper;

import com.br.zamp.domain.Account;
import com.br.zamp.dto.account.CreateAccountDTO;
import com.br.zamp.dto.account.ReadAndUpdateAccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AccountMapper implements BaseMapper<Account, CreateAccountDTO, ReadAndUpdateAccountDTO> {

  @Override
  public ReadAndUpdateAccountDTO toReadAndUpdateDTO(Account entity) {
    return new ReadAndUpdateAccountDTO(
      entity.getId(),
      entity.getName(),
      entity.getCode(),
      entity.getType(),
      entity.getBalance()
    );
  }
}