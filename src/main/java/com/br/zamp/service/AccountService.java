package com.br.zamp.service;

import com.br.zamp.config.dto.SelectOption;
import com.br.zamp.controller.specifications.AccountSpecification;
import com.br.zamp.domain.Account;

import java.util.Set;
import java.util.UUID;

public interface AccountService extends CrudService<Account> {
  Set<SelectOption<UUID>> getAccountsSelect(AccountSpecification user);
}