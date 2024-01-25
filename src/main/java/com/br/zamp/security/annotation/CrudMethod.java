package com.br.zamp.security.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CrudMethod {
  CREATE("create"),
  UPDATE("update"),
  READ("findById"),
  READ_ALL("findAllBySpec"),
  DELETE("delete"),
  ;

  private final String description;
}
