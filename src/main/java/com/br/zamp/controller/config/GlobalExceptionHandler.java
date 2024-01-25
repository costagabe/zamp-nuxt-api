package com.br.zamp.controller.config;

import com.br.zamp.config.dto.ErrorResponse;
import com.br.zamp.exceptions.ProfileLevelException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({AuthorizationServiceException.class, ProfileLevelException.class})
  @ResponseBody
  public ErrorResponse handleAuthorizationServiceException(AuthorizationServiceException ex) {
    return new ErrorResponse(ex.getMessage(),HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(ClassCastException.class)
  @ResponseBody
  public ErrorResponse handleClassCastException(ClassCastException ex) {
    return new ErrorResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
  }
}