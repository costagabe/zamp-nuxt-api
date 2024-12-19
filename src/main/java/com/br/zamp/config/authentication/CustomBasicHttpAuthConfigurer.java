package com.br.zamp.config.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;

@RequiredArgsConstructor
public class CustomBasicHttpAuthConfigurer
    implements Customizer<HttpBasicConfigurer<HttpSecurity>> {

  private final CustomAuthenticationDetailsSource customAuthenticationDetailsSource;
  private final AuthenticationEntryPoint customAuthenticationEntryPoint;

  @Override
  public void customize(HttpBasicConfigurer<HttpSecurity> config) {
    config
        .authenticationDetailsSource(customAuthenticationDetailsSource)
        .authenticationEntryPoint(customAuthenticationEntryPoint);
  }
}
