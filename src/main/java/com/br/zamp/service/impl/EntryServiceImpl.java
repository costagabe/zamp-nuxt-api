package com.br.zamp.service.impl;

import com.br.zamp.domain.Entry;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.EntryRepository;
import com.br.zamp.service.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService {

  private final EntryRepository repository;

  @Override
  public Entry create(Entry entity) {
    return repository.save(entity);
  }

  @Override
  public Entry update(Entry entity) {
    return null;
  }

  @Override
  public Entry findById(UUID uuid) {
    return repository.findById(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Entry)."));
  }

  @Override
  public Page<Entry> findAll(Specification<Entry> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}