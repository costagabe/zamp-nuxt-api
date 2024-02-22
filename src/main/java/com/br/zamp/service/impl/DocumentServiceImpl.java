package com.br.zamp.service.impl;

import com.br.zamp.domain.Document;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.DocumentRepository;
import com.br.zamp.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

  private final DocumentRepository repository;

  @Override
  public Document create(Document entity) {
    return repository.save(entity);
  }

  @Override
  public Document update(Document entity) {
    return null;
  }

  @Override
  public Document findById(UUID uuid) {
    return repository.findById(uuid)
      .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Document)."));
  }

  @Override
  public Page<Document> findAll(Specification<Document> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}