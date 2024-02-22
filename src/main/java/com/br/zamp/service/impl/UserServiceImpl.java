package com.br.zamp.service.impl;

import com.br.zamp.domain.User;
import com.br.zamp.exceptions.DuplicatedObjectException;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.exceptions.ProfileLevelException;
import com.br.zamp.repository.UserRepository;
import com.br.zamp.security.AuthenticatedUser;
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
  private final AuthenticatedUser authenticatedUser;

  @Override
  public User create(User user) {
    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
      throw new DuplicatedObjectException("Erro ao criar usuário.", "email", "Já existe um usuário com teste e-mail.");
    }
    return userRepository.save(user);
  }

  @Override
  public User update(User user) {
    validateUserProfiles(user);

    return userRepository.save(user);
  }

  @Override
  public User findById(UUID uuid) {
    return userRepository.findById(uuid)
      .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
  }

  @Override
  public Page<User> findAll(Specification<User> specification, Pageable pageable) {
    return userRepository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    userRepository.deleteById(uuid);
  }

  private void validateUserProfiles(User user) {
    if (authenticatedUser.getUser().getMaxUserProfileLevel().getLevel() < user.getMaxUserProfileLevel().getLevel()) {
      throw new ProfileLevelException("Usuário não pode ter um perfil com nível maior que o seu.");
    }
  }
}
