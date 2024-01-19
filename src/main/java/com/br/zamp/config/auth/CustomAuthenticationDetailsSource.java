package com.br.zamp.config.auth;

import com.br.zamp.security.AuthUser;
import com.br.zamp.security.JpaUserDetailsService;
import com.nimbusds.jose.util.Pair;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RequiredArgsConstructor
public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, Object> {

  private final JpaUserDetailsService customUserDetailsService;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Object buildDetails(HttpServletRequest context) {

    var encodedAuth = getAuthFromHeaders(context);

    String decodedAuth = getDecodedAuth(encodedAuth);

    Pair<String, String> credentials = extractCredentials(decodedAuth);
    String username = credentials.getLeft();
    String password = credentials.getRight();

    AuthUser authenticated = customUserDetailsService.loadUserByUsername(username);

    if (!passwordEncoder.matches(password, authenticated.getPassword())) {
      throw new BadCredentialsException("Usuário inexistente ou senha inválida");
    }
    if (!authenticated.isAccountNonExpired()) {
      throw new AccountExpiredException("A conta encontra-se expirada.");
    }
    if (!authenticated.isEnabled()) {
      throw new DisabledException("A conta encontra-se inativa.");
    }
    return authenticated;
  }

  private static String getAuthFromHeaders(HttpServletRequest context) {
    return context.getHeader("authorization").replace("Basic ", "");
  }

  private Pair<String, String> extractCredentials(String authData) {
    var splitAuth = authData.split(":");
    return Pair.of(splitAuth[0], splitAuth[1]);
  }

  private static String getDecodedAuth(String encodedAuth) {
    return new String(Base64.getDecoder().decode(encodedAuth), StandardCharsets.UTF_8);
  }
}
