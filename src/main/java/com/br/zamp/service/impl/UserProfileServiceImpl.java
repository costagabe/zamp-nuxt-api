package com.br.zamp.service.impl;

import com.br.zamp.domain.UserProfile;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.UserProfileRepository;
import com.br.zamp.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
  private final UserProfileRepository userProfileRepository;

  @Override
  public UserProfile create(UserProfile user) {
    return userProfileRepository.save(user);
  }

  @Override
  public UserProfile update(UserProfile user) {
    return null;
  }

  @Override
  public UserProfile findById(UUID uuid) {
    return userProfileRepository.findById(uuid)
        .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
  }

  @Override
  public Page<UserProfile> findAll(Specification<UserProfile> specification, Pageable pageable) {
    return userProfileRepository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    userProfileRepository.deleteById(uuid);
  }
}