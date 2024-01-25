package com.br.zamp.config.authentication;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthenticationErrorException extends RuntimeException {
  private Integer status;

  public AuthenticationErrorException(String message, Integer status) {
    super(message);

    this.status = status;
  }
}
