package com.br.zamp.service.impl;

import com.br.zamp.domain.Account;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.AccountRepository;
import com.br.zamp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository repository;

  @Override
  public Account create(Account entity) {
    return repository.save(entity);
  }

  @Override
  public Account update(Account entity) {
    return null;
  }

  @Override
  public Account findById(UUID uuid) {
    return repository.findById(uuid)
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
}