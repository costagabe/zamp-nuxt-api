package com.br.zamp.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor()
public class ProfileLevelException extends RuntimeException {
  private final String message;
  private Integer level;
}
