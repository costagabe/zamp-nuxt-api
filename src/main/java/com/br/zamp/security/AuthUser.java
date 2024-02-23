package com.br.zamp.security;


import com.br.zamp.domain.User;
import com.br.zamp.domain.enums.UserSituation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@AllArgsConstructor
public class AuthUser implements UserDetails {
  private User user;

  @Override
  public String getUsername() {
    return user.getEmail();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return user.fetchAndFlattenAuthorities();
  }

  public Collection<? extends GrantedAuthority> getPermissions() {
    return user.fetchAndFlattenGrantedAuthorities();
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return user.getSituation().equals(UserSituation.ACTIVE);
  }

}
