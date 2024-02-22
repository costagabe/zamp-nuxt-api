package com.br.zamp.service.impl;

import com.br.zamp.domain.Lessee;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.LesseeRepository;
import com.br.zamp.service.LesseeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LesseeServiceImpl implements LesseeService {

  private final LesseeRepository repository;

  @Override
  public Lessee create(Lessee entity) {
    return repository.save(entity);
  }

  @Override
  public void update(Lessee entity) {
    repository.save(entity);
  }

  @Override
  public Lessee findById(UUID uuid) {
    return repository.findById(uuid)
      .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Lessee)."));
  }

  @Override
  public Page<Lessee> findAll(Specification<Lessee> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}