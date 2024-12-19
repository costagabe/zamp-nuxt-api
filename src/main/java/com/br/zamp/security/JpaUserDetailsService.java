package com.br.zamp.security;

import com.br.zamp.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
  @Setter(onMethod_ = @Autowired)
  private UserRepository userRepository;

  @Override
  public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
        .findByEmail(username)
        .map(AuthUser::new)
        .orElseThrow(() -> new BadCredentialsException("Usuário inexistente ou senha inválida"));
  }
}
