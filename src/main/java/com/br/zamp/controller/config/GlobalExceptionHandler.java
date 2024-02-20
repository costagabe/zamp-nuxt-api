package com.br.zamp.controller.config;

import com.br.zamp.config.dto.ErrorResponse;
import com.br.zamp.exceptions.DuplicatedObjectException;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.exceptions.ProfileLevelException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({AuthorizationServiceException.class, ProfileLevelException.class})
  @ResponseBody
  public ErrorResponse handleAuthorizationServiceException(AuthorizationServiceException ex, HttpServletResponse response) {
    response.setStatus(HttpStatus.FORBIDDEN.value());
    return new ErrorResponse(ex.getMessage(), HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler({ObjectNotFoundException.class})
  @ResponseBody
  public ErrorResponse handleNotFoundException(ObjectNotFoundException ex, HttpServletResponse response) {
    response.setStatus(HttpStatus.NOT_FOUND.value());
    return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, ex.getValidations());
  }

  @ExceptionHandler({DuplicatedObjectException.class})
  @ResponseBody
  public ErrorResponse handleDuplicatedObjectException(DuplicatedObjectException ex, HttpServletResponse response) {
    response.setStatus(HttpStatus.CONFLICT.value());
    return new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT, ex.getValidations());
  }

  @ExceptionHandler(ClassCastException.class)
  @ResponseBody
  public ErrorResponse handleClassCastException(ClassCastException ex, HttpServletResponse response) {
    response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    return new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}