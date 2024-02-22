package com.br.zamp.service.impl;

import com.br.zamp.domain.Lessor;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.LessorRepository;
import com.br.zamp.service.LessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessorServiceImpl implements LessorService {

  private final LessorRepository repository;

  @Override
  public Lessor create(Lessor entity) {
    return repository.save(entity);
  }

  @Override
  public void update(Lessor entity) {
    repository.save(entity);
  }

  @Override
  public Lessor findById(UUID uuid) {
    return repository.findById(uuid)
      .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Lessor)."));
  }

  @Override
  public Page<Lessor> findAll(Specification<Lessor> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}