package com.br.zamp.service;

import com.br.zamp.config.dto.SelectOption;
import com.br.zamp.domain.UserProfile;

import java.util.Set;
import java.util.UUID;

public interface UserProfileService extends CrudService<UserProfile> {
  Set<SelectOption<UUID>> getUserProfileSelectList(Integer maxLevel);

  Set<UserProfile> findByIdIn(Set<UUID> userProfileIds);
}
