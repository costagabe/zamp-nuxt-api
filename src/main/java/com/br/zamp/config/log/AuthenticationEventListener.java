package com.br.zamp.config.log;


import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {

  private static final Logger logger = LogManager.getLogger(AuthenticationEventListener.class);

  @Override
  public void onApplicationEvent(@NonNull AbstractAuthenticationEvent authenticationEvent) {
    if (authenticationEvent instanceof InteractiveAuthenticationSuccessEvent) {
      // ignores to prevent duplicate logging with AuthenticationSuccessEvent
      return;
    }
    Authentication authentication = authenticationEvent.getAuthentication();
    String auditMessage = "Login attempt with username: " + authentication.getName() + "\t\tSuccess: " + authentication.isAuthenticated();
    logger.info(auditMessage);
  }

}