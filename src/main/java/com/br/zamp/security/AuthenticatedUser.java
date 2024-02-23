package com.br.zamp.security;

import com.br.zamp.domain.User;
import com.br.zamp.repository.UserRepository;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class AuthenticatedUser {
  private final UUID userId;
  private final UserRepository userRepository;

  public AuthenticatedUser(UserRepository userRepository) {
    JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    Jwt jwt = (Jwt) jwtAuth.getPrincipal();
    this.userId = UUID.fromString(jwt.getClaims().get("id").toString());

    this.userRepository = userRepository;
  }

  public User getUser() {
    if (SecurityContextHolder.getContext().getAuthentication() == null) {
      return userRepository.findByEmail("admin").orElseThrow();
    }
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
    return userRepository.findByEmail(email).orElseThrow();
  }

}
