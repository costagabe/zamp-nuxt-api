package com.br.zamp.service.impl;

import com.br.zamp.domain.Contract;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.ContractRepository;
import com.br.zamp.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

  private final ContractRepository repository;

  @Override
  public Contract create(Contract entity) {
    return repository.save(entity);
  }

  @Override
  public Contract update(Contract entity) {
    return null;
  }

  @Override
  public Contract findById(UUID uuid) {
    return repository.findById(uuid)
      .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Contract)."));
  }

  @Override
  public Page<Contract> findAll(Specification<Contract> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}