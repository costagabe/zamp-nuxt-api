package com.br.zamp.config.dto;

import lombok.Data;

@Data
public class ResponseApi<T> {
  private T data;
  private ErrorResponse error;
}
