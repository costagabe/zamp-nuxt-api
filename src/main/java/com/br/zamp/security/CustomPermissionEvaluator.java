package com.br.zamp.security;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

  @Override
  public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
    if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)) {
      return false;
    }
    try {
      Method method = getMethodFromClassPath(targetDomainObject.toString());
      return hasPrivilege(auth, method, permission.toString().toUpperCase());
    } catch (ClassCastException | ClassNotFoundException | NoSuchMethodException e) {
      return false;
    }
  }

  private Method getMethodFromClassPath(String classAndMethodPath)
      throws ClassNotFoundException, NoSuchMethodException {
    int lastDotIndex = classAndMethodPath.lastIndexOf(".");
    if (lastDotIndex == -1 || lastDotIndex == classAndMethodPath.length() - 1) {
      throw new IllegalArgumentException("Path must be in the format 'fullClassName.methodName'");
    }

    String className = classAndMethodPath.substring(0, lastDotIndex);
    String methodName = classAndMethodPath.substring(lastDotIndex + 1);

    // Load the class
    Class<?> clazz = Class.forName(className);

    // Find method without parameter
    // If your method has parameters you need to include them
    for (Method method : clazz.getDeclaredMethods()) {
      if (method.getName().equals(methodName)) {
        return method;
      }
    }

    throw new NoSuchMethodException(
        String.format("No such method: %s for class: %s", methodName, className));
  }

  @Override
  public boolean hasPermission(
      Authentication auth, Serializable targetId, String targetType, Object permission) {

    return true; // Not used in this example
  }

  private boolean hasPrivilege(Authentication auth, Method method, String permission) {
    if (method == null) {
      return false;
    }
    // Logic for checking permissions and roles
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
    return auth.getAuthorities().contains(authority);
  }
}