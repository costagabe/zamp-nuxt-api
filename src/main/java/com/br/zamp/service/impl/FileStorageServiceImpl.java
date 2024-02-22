package com.br.zamp.service.impl;

import com.br.zamp.domain.FileStorage;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.FileStorageRepository;
import com.br.zamp.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

  private final FileStorageRepository repository;

  @Override
  public FileStorage create(FileStorage entity) {
    return repository.save(entity);
  }

  @Override
  public void update(FileStorage entity) {
    repository.save(entity);
  }

  @Override
  public FileStorage findById(UUID uuid) {
    return repository.findById(uuid)
      .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (FileStorage)."));
  }

  @Override
  public Page<FileStorage> findAll(Specification<FileStorage> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}