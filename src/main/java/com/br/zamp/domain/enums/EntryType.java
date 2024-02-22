package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EntryType {
  IN("Entrada"),
  OUT("Saída"),
  TRANSFER("Transferência");

  private final String name;
}
