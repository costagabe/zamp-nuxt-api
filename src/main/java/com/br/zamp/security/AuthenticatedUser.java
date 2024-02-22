package com.br.zamp.security;

import com.br.zamp.domain.User;
import com.br.zamp.repository.UserRepository;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class AuthenticatedUser {
  private final User user;

  public AuthenticatedUser(UserRepository userRepository) {
    if (SecurityContextHolder.getContext().getAuthentication() == null) {
      user = userRepository.findByEmail("admin").orElseThrow();
      return;
    }
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
    user = userRepository.findByEmail(email).orElseThrow();
  }

}
