package com.br.zamp.exceptions;

import lombok.Getter;

@Getter
public class ProfileLevelException extends RuntimeException {
  private final String message;
  private Integer level;

  public ProfileLevelException(String message) {
    super(message);
    this.message = message;
  }
}
