package com.br.zamp.config;

import com.br.zamp.config.dto.ApiResponse;
import com.br.zamp.config.dto.ErrorResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

//@ControllerAdvice
public class ApiResponseAdvice implements ResponseBodyAdvice<Object> {

  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    // Check if the Advice is applicable to the controller method
    // For simplicity, let's apply it to all methods
    return true;
  }

  @Override
  public Object beforeBodyWrite(
      Object body,
      @NonNull MethodParameter returnType,
      @NonNull MediaType selectedContentType,
      @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
      @NonNull ServerHttpRequest request,
      @NonNull ServerHttpResponse response
  ) {
    if (body instanceof ApiResponse) {
      return body;
    }
    if(body instanceof ErrorResponse) {
      return new ApiResponse<>(null, (ErrorResponse) body);
    }
    return new ApiResponse<>(body, null);
  }
}