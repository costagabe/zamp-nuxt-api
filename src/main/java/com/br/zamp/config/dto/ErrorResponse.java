package com.br.zamp.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
  private final String title;
  private final HttpStatus status;
  private Map<String, List<String>> validations;

  public Integer getStatus() {
    return status.value();
  }

}
