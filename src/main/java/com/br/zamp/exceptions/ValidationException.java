package com.br.zamp.exceptions;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ValidationException extends RuntimeException {
  protected Map<String, List<String>> validations = new HashMap<>();

  public ValidationException(String message) {
    super(message);
  }

  public ValidationException(String message, String field, String fieldMessage) {
    super(message);
    validations.put(field, List.of(fieldMessage));
  }
}
