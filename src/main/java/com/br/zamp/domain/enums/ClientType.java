package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ClientType {
  LESSEE("LESSEE"),
  LESSOR("LESSOR"),
  ;

  private final String name;

}
