package com.br.zamp.dto.user;

import com.br.zamp.domain.enums.UserSituation;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;
import java.util.UUID;

public record ReadAndUpdateUserDTO(
  UUID id,
  String name,
  String email,
  UserSituation situation,
  @NotEmpty(message = "O usuário deve possuir ao menos um perfil.")  Set<UUID> profileIds,
  String profile) {
}
