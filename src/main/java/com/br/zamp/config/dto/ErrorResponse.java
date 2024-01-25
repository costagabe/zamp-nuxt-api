package com.br.zamp.config.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ErrorResponse {
  private final String title;
  private final HttpStatus status;
  private List<String> messages;

  public Integer getStatus() {
    return status.value();
  }

}
