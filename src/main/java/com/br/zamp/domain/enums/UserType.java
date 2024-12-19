package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public @Getter enum UserType {
  ADMIN("ROLE_ADMIN"),
  CUSTOMER("ROLE_CUSTOMER");

  private final String name;
}
