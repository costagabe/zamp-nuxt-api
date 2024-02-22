package com.br.zamp.mapper;

import com.br.zamp.domain.Account;
import com.br.zamp.dto.account.CreateAccountDTO;
import com.br.zamp.dto.account.ReadAndUpdateAccountDTO;
import com.br.zamp.service.AccountService;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class AccountMapper implements BaseMapper<Account, CreateAccountDTO, ReadAndUpdateAccountDTO> {
  @Setter(onMethod_ = @Autowired)
  private AccountService accountService;

  @Override
  public ReadAndUpdateAccountDTO toReadAndUpdateDTO(Account entity) {
    Float balance = Optional.ofNullable(accountService.getBalance(entity.getId())).orElse(0.0f);

    return new ReadAndUpdateAccountDTO(
      entity.getId(),
      entity.getName(),
      entity.getCode(),
      entity.getType(),
      balance
    );
  }
}