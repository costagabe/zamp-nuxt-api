package com.br.zamp.security;

import com.br.zamp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByEmail(username)
        .map(AuthUser::new)
        .orElseThrow(() -> new BadCredentialsException("Usuário inexistente ou senha inválida"));
  }

}
