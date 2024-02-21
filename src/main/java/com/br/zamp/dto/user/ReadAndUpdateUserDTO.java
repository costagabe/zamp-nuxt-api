package com.br.zamp.dto.user;

import com.br.zamp.domain.enums.UserSituation;

import java.util.Set;
import java.util.UUID;

public record ReadAndUpdateUserDTO(
  UUID id,
  String name,
  String email,
  UserSituation situation,
  Set<UUID> profileIds,
  String profile) {
}
