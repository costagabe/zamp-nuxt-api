package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EntryType {
  IN("Entrada"),
  OUT("Saída");
  private final String name;
}
