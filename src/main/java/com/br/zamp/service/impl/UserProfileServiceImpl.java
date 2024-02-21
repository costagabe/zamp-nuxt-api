package com.br.zamp.service.impl;

import com.br.zamp.config.dto.SelectOption;
import com.br.zamp.domain.User;
import com.br.zamp.domain.UserProfile;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.repository.UserProfileRepository;
import com.br.zamp.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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
      .orElseThrow(() -> new ObjectNotFoundException("Erro ao encontrar perfil.", "profileId", "Perfil não encontrado."));
  }

  @Override
  public Page<UserProfile> findAll(Specification<UserProfile> specification, Pageable pageable) {
    return userProfileRepository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    userProfileRepository.deleteById(uuid);
  }

  @Override
  public Set<SelectOption<UUID>> getUserProfileSelectList(User user) {
    var profiles = userProfileRepository.findUserProfileByUserProfileLevel(user.getMaxUserProfileLevel().getLevel());

    return profiles.stream().map(profile ->
        SelectOption
          .<UUID>builder()
          .value(profile.getId())
          .label(profile.getOriginalName())
          .build()
      )
      .collect(Collectors.toSet());
  }

  @Override
  public Set<UserProfile> findByIdIn(Set<UUID> ids) {
    return userProfileRepository.findByIdIn(ids);
  }
}
