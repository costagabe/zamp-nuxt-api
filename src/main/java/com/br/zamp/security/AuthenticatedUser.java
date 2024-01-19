package com.br.zamp.security;

import com.br.zamp.domain.User;
import com.br.zamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class AuthenticatedUser {
  private final UserRepository userRepository;

  public User getUser() {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
    return userRepository.findByEmail(email).orElseThrow();
  }
}
