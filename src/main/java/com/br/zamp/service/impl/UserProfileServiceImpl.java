package com.br.zamp.service.impl;

import com.br.zamp.config.dto.SelectOption;
import com.br.zamp.domain.User;
import com.br.zamp.domain.UserProfile;
import com.br.zamp.dto.permission.PermissionDTO;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.exceptions.ProfileLevelException;
import com.br.zamp.repository.UserProfileRepository;
import com.br.zamp.security.AuthenticatedUser;
import com.br.zamp.service.UserProfileService;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
  private final UserProfileRepository userProfileRepository;
  private final AuthenticatedUser authenticatedUser;

  @Override
  public UserProfile create(UserProfile profile) {
    validateUserProfiles(profile);
    return userProfileRepository.save(profile);
  }

  @Override
  public void update(UserProfile profile) {
    validateUserProfiles(profile);
    userProfileRepository.save(profile);
  }

  @Override
  public UserProfile findById(UUID uuid) {
    return userProfileRepository
        .findById(uuid)
        .orElseThrow(
            () ->
                new ObjectNotFoundException(
                    "Erro ao encontrar perfil.", "profileId", "Perfil não encontrado."));
  }

  @Override
  public Page<UserProfile> findAll(Specification<UserProfile> specification, Pageable pageable) {
    var level = authenticatedUser.getMaxLevel();

    if (specification == null) {
      specification =
          (root, query, criteriaBuilder) ->
              criteriaBuilder.lessThanOrEqualTo(root.get("level"), criteriaBuilder.literal(level));
    } else {
      specification.and(
          (root, query, criteriaBuilder) ->
              criteriaBuilder.lessThanOrEqualTo(root.get("level"), criteriaBuilder.literal(level)));
    }

    specification.and(
        (root, query, criteriaBuilder) ->
            criteriaBuilder.lessThanOrEqualTo(root.get("level"), criteriaBuilder.literal(level)));

    return userProfileRepository.findAll(specification, pageable);
  }

  @Override
  public void delete(UUID uuid) {
    userProfileRepository.deleteById(uuid);
  }

  @Override
  public Set<SelectOption<UUID>> getUserProfileSelectList(Integer maxLevel) {
    var profiles = userProfileRepository.findUserProfileByUserProfileLevel(maxLevel);

    return profiles.stream()
        .map(
            profile ->
                SelectOption.<UUID>builder()
                    .value(profile.getId())
                    .label(profile.getOriginalName())
                    .build())
        .collect(Collectors.toSet());
  }

  @Override
  public Set<UserProfile> findByIdIn(Set<UUID> ids) {
    return userProfileRepository.findByIdIn(ids);
  }

  @Override
  public Set<PermissionDTO> getUserProfilePermissionList(User user) {
    return user.fetchAndFlattenPermissions().stream()
        .map(v -> new PermissionDTO(v.toString(), v.getDescription(), v.getType().getDescription()))
        .collect(Collectors.toSet());
  }

  private void validateUserProfiles(UserProfile profile) {
    if (authenticatedUser.getMaxLevel() < profile.getLevel()) {
      throw new ProfileLevelException(
          "Usuário não criar/editar ter um perfil com nível maior que o seu próprio.");
    }
  }
}
