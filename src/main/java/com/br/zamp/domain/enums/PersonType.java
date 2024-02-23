package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PersonType {
  PF("Pessoa Física"),
  PJ("Pessoa Jurídica"),
  ;

  private final String name;

}
