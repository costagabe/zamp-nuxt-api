package com.br.zamp.config.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {
  private final String title;
  private List<String> messages;
}
