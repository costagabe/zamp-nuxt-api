package com.br.zamp.service.impl;

import com.br.zamp.domain.Company;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.CompanyRepository;
import com.br.zamp.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

  final CompanyRepository repository;

  @Override
  public Company create(Company entity) {
    return repository.save(entity);
  }

  @Override
  public Company update(Company entity) {
    return null;
  }

  @Override
  public Company findById(UUID uuid) {
    return repository.findById(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Company)."));
  }

  @Override
  public Page<Company> findAll(Specification<Company> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}