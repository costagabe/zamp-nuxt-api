package com.br.zamp.service.impl;

import com.br.zamp.domain.Client;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.ClientRepository;
import com.br.zamp.service.AddressService;
import com.br.zamp.service.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

  private final ClientRepository repository;
  private final AddressService addressService;

  @Override
  @Transactional
  public Client create(Client entity) {
    addressService.create(entity.getAddress());
    return repository.save(entity);
  }

  @Override
  @Transactional
  public void update(Client entity) {
    addressService.update(entity.getAddress());
    repository.save(entity);
  }

  @Override
  public Client findById(UUID uuid) {
    return repository.findById(uuid)
      .orElseThrow(() -> new ObjectNotFoundException("Não encontrado (Client)."));
  }

  @Override
  public Page<Client> findAll(Specification<Client> specification, Pageable pageable) {
    return repository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    repository.deleteById(uuid);
  }
}