package com.br.zamp.dto.user;

import jakarta.validation.constraints.NotEmpty;

import java.util.Set;
import java.util.UUID;

public record CreateUserDTO(
  String name,
  String email,
  @NotEmpty(message = "O usuário deve possuir ao menos um perfil.") Set<UUID> profileIds
) {
}
