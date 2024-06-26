package com.br.zamp.config;

import com.br.zamp.config.authentication.AuthenticationErrorException;
import com.br.zamp.config.dto.ApiResponse;
import com.br.zamp.config.dto.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
  private final ObjectMapper objectMapper;

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
    try {
      if (exception instanceof DisabledException) {
        throw new AuthenticationErrorException(exception.getMessage(), HttpServletResponse.SC_FORBIDDEN);
      } else if (exception instanceof BadCredentialsException || exception instanceof AccountExpiredException) {
        throw new AuthenticationErrorException(exception.getMessage(), HttpServletResponse.SC_UNAUTHORIZED);
      }  else if (exception instanceof InternalAuthenticationServiceException || exception instanceof InsufficientAuthenticationException) {
        throw new AuthenticationErrorException("Dados de login inválidos", HttpServletResponse.SC_UNAUTHORIZED);
      }
    } catch (AuthenticationErrorException e) {
      ApiResponse<?> responseData = new ApiResponse<>();
      ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.UNAUTHORIZED);

      responseData.setError(error);
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");

      response.setStatus(e.getStatus());
      response.getWriter().println(objectMapper.writeValueAsString(responseData));
      response.getWriter().flush();
    }
  }

}