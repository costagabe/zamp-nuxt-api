package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientType {
  LESSEE("LESSEE"),
  LESSOR("LESSOR"),
  ;

  private final String name;

}
