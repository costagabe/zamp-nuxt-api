package com.br.zamp.service.impl;

import com.br.zamp.config.dto.SelectOption;
import com.br.zamp.controller.specifications.AccountSpecification;
import com.br.zamp.domain.Account;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.AccountRepository;
import com.br.zamp.service.AccountService;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository repository;

  @Override
  public Account create(Account entity) {
    return repository.save(entity);
  }

  @Override
  public void update(Account account) {
    repository.save(account);
  }

  @Override
  public Account findById(UUID uuid) {
    return repository
        .findById(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Account)."));
  }

  @Override
  public Page<Account> findAll(Specification<Account> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }

  @Override
  public Set<SelectOption<UUID>> getAccountsSelect(AccountSpecification spec) {
    List<Account> accountEntities = repository.findAll(spec);

    return accountEntities.stream()
        .map(account -> new SelectOption<>(account.getId(), account.getName()))
        .collect(Collectors.toSet());
  }

  @Override
  public Float getBalance(UUID accountId) {
    return repository.getBalance(accountId);
  }
}