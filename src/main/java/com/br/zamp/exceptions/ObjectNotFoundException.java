package com.br.zamp.exceptions;


import lombok.Getter;

@Getter
public class ObjectNotFoundException extends ValidationException {

  public ObjectNotFoundException(String message) {
    super(message);
  }

  public ObjectNotFoundException(String message, String field, String fieldMessage) {
    super(message, field, fieldMessage);
  }
}
