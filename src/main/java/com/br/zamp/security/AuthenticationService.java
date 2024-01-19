package com.br.zamp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final JwtService jwtService;

  public String authenticate(AuthUser authentication) {
    return jwtService.generateToken(authentication);
  }
}
