package com.br.zamp.config.authorization;

import com.br.zamp.enums.Permission;
import com.br.zamp.exceptions.ProfileLevelException;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class CrudAuthorizationInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
    try {
      Class<?> clazz = ((HandlerMethod) handler).getBean().getClass();

      CrudPermission crudAnnotation = findAnnotation(clazz, CrudPermission.class);
      String method = ((HandlerMethod) handler).getMethod().getName();

      if (crudAnnotation != null) {
        Integer level = getUserLevel();
        Set<String> permissionSet = populatePermissionSet(method, crudAnnotation, level);

        if (canContinue(permissionSet)) {
          return true;
        } else {
          throw new AuthorizationServiceException("Usuário sem autorização.");
        }
      }
      return true;
    } catch (ClassCastException e) {
      return true;
    }
  }

  private static boolean canContinue(Set<String> permissionSet) {
    return SecurityContextHolder
        .getContext()
        .getAuthentication()
        .getAuthorities()
        .stream()
        .anyMatch(v -> permissionSet.contains(v.getAuthority()));
  }

  private static Integer getUserLevel() {
    return SecurityContextHolder
        .getContext()
        .getAuthentication()
        .getAuthorities()
        .stream()
        .filter(v -> v.getAuthority().contains("LEVEL_"))
        .map(v -> v.getAuthority().replace("LEVEL_", ""))
        .map(Integer::valueOf)
        .findFirst()
        .orElseThrow(() -> new ProfileLevelException("Conta sem nível no perfil."));
  }

  private Set<String> populatePermissionSet(String method, CrudPermission crudAnnotation, Integer userLevel) {
    List<CrudPermissionType> permissionTypes = Arrays.stream(crudAnnotation.value()).toList();

    return permissionTypes
        .stream()
        .filter(v -> v.level() < userLevel)
        .filter(v -> v.method().getDescription().equals(method))
        .flatMap(v -> Arrays.stream(v.permission()).map(Permission::getAuthority))
        .collect(Collectors.toSet());
  }

  private <A extends Annotation> A findAnnotation(Class<?> targetClass, @NonNull Class<A> annotationClass) {
    return AnnotationUtils.findAnnotation(targetClass, annotationClass);
  }
}