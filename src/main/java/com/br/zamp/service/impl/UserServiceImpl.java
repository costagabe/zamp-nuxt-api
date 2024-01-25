package com.br.zamp.service.impl;

import com.br.zamp.domain.User;
import com.br.zamp.dto.Filter;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.UserRepository;
import com.br.zamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public User create(User user) {
    return null;
  }

  @Override
  public User update(User user) {
    return null;
  }

  @Override
  public User findById(UUID uuid) {
    return userRepository.findById(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
  }

  @Override
  public User findByFilter(Filter filter) {
    return null;
  }

  @Override
  public Page<User> findAll(Specification<User> specification, Pageable pageable) {
    return userRepository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {

  }
}
