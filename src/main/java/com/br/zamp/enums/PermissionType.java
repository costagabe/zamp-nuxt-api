package com.br.zamp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PermissionType {
  REQUISICAO("Requisição", 1),
  MENU("Menu", 2),
  GERAL("Geral", 3)
  ;

  private final String descricao;
  private final Integer id;
}
