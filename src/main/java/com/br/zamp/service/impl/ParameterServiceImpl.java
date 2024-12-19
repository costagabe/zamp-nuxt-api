package com.br.zamp.service.impl;

import com.br.zamp.domain.Parameter;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.ParameterRepository;
import com.br.zamp.service.ParameterService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParameterServiceImpl implements ParameterService {

  private final ParameterRepository repository;

  @Override
  public Parameter create(Parameter entity) {
    return repository.save(entity);
  }

  @Override
  public void update(Parameter entity) {
    repository.save(entity);
  }

  @Override
  public Parameter findById(UUID uuid) {
    return repository
        .findById(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Parameter)."));
  }

  @Override
  public Page<Parameter> findAll(Specification<Parameter> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}