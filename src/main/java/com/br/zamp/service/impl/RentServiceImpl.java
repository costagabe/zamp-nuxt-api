package com.br.zamp.service.impl;

import com.br.zamp.domain.Rent;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.RentRepository;
import com.br.zamp.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

  private final RentRepository repository;

  @Override
  public Rent create(Rent entity) {
    return repository.save(entity);
  }

  @Override
  public Rent update(Rent entity) {
    return null;
  }

  @Override
  public Rent findById(UUID uuid) {
    return repository.findById(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Rent)."));
  }

  @Override
  public Page<Rent> findAll(Specification<Rent> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}