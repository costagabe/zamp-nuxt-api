package com.br.zamp.config.authorization;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//@Aspect
//@Component
public class PermissionAnnotationBasedSecurity {

  @Pointcut("@annotation(com.br.zamp.security.annotation.CrudPermission)")
  private void customSecurityAnnotation() {}

  @Around("com.br.zamp.config.authorization.PermissionAnnotationBasedSecurity.customSecurityAnnotation()")
  public Object doSomething(ProceedingJoinPoint pjp) throws Throwable {
    HttpServletRequest req = getRequest();
    // Check header values
    // Throw Spring's AccessDeniedException if needed
    return pjp.proceed();
  }

  private HttpServletRequest getRequest() {
    ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    return sra.getRequest();
  }
}
