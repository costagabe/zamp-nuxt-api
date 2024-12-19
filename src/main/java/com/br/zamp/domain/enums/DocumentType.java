package com.br.zamp.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DocumentType {
  BUILDING("Imóvel"),
  RENT("Aluguel"),
  PERSON("Pessoa"
  );

  private final String description;
}
