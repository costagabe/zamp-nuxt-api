package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public @Getter enum PersonType {
  PF("Pessoa Física"),
  PJ("Pessoa Jurídica"),
  ;

  private final String name;
}
