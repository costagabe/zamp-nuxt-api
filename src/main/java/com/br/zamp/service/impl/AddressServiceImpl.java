package com.br.zamp.service.impl;

import com.br.zamp.domain.Address;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.AddressRepository;
import com.br.zamp.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final AddressRepository repository;

  @Override
  public Address create(Address entity) {
    return repository.save(entity);
  }

  @Override
  public Address update(Address entity) {
    return null;
  }

  @Override
  public Address findById(UUID uuid) {
    return repository.findById(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Address)."));
  }

  @Override
  public Page<Address> findAll(Specification<Address> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}