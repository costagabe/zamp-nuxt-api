package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ClientType {
  CLIENT("CLIENT"),
  LESSOR("LESSOR"),
  ;

  private final String name;

}
