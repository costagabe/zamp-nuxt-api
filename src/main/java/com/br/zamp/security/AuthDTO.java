package com.br.zamp.security;

public class AuthDTO {
  public record LoginRequest(String username, String password) {}

  public record Response(String message, String token) {}
}