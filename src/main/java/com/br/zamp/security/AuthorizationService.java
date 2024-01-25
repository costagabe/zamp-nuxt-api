package com.br.zamp.security;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
@Setter(onMethod_ = @Autowired)
public class AuthorizationService {

  private PermissionEvaluator permissionEvaluator;

  public boolean hasPermission(Authentication auth, Method targetDomainObject, Object permission) {
    // ...
    // You can put debug points here and inspect principal and its attributes
    return permissionEvaluator.hasPermission(auth, targetDomainObject, permission);
  }
}