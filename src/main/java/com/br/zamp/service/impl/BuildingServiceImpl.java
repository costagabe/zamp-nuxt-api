package com.br.zamp.service.impl;

import com.br.zamp.domain.Building;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.BuildingRepository;
import com.br.zamp.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

  private final BuildingRepository repository;

  @Override
  public Building create(Building entity) {
    return repository.save(entity);
  }

  @Override
  public Building update(Building entity) {
    return null;
  }

  @Override
  public Building findById(UUID uuid) {
    return repository.findById(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Building)."));
  }

  @Override
  public Page<Building> findAll(Specification<Building> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}