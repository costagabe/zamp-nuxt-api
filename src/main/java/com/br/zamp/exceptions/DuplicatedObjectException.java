package com.br.zamp.exceptions;

import lombok.Getter;

@Getter
public class DuplicatedObjectException extends ValidationException {

  public DuplicatedObjectException(String message) {
    super(message);
  }

  public DuplicatedObjectException(String message, String field, String fieldMessage) {
    super(message, field, fieldMessage);
  }
}
