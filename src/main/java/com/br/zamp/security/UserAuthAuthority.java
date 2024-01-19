package com.br.zamp.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Data
public class UserAuthAuthority implements GrantedAuthority {
  private final String authority;
}
