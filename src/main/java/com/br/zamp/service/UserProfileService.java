package com.br.zamp.service;

import com.br.zamp.config.dto.SelectOption;
import com.br.zamp.domain.User;
import com.br.zamp.domain.UserProfile;
import com.br.zamp.dto.permission.PermissionDTO;

import java.util.Set;
import java.util.UUID;

public interface UserProfileService extends CrudService<UserProfile> {
  Set<SelectOption<UUID>> getUserProfileSelectList(Integer maxLevel);

  Set<UserProfile> findByIdIn(Set<UUID> userProfileIds);

  Set<PermissionDTO> getUserProfilePermissionList(User user);
}
