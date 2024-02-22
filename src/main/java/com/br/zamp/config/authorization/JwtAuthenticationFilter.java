package com.br.zamp.config.authorization;

import com.br.zamp.security.JpaUserDetailsService;
import com.br.zamp.security.SecurityUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Setter(onMethod_ = @Autowired)
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private static final String AUTH_URL = "/auth";
  private static final String AUTHORIZATION = "Authorization";
  JpaUserDetailsService userDetailsServiceImpl;

  @Override
  protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse
    response, @NonNull FilterChain filterChain) throws ServletException, IOException {

    if (request.getRequestURI().equals(AUTH_URL) && request.getMethod().equals("POST")) {
      filterChain.doFilter(request, response);
      return;
    }

    String token = SecurityUtil.extractTokenFromCookies(request);

    if (token == null) {
      filterChain.doFilter(request, response);
      return;
    }

    HttpServletRequest wrappedRequest = new HttpServletRequestWrapper(request) {
      @Override
      public String getHeader(String name) {
        if (AUTHORIZATION.equals(name)) {
          return "Bearer " + token;
        }
        return super.getHeader(name);
      }
    };

    filterChain.doFilter(wrappedRequest, response);
  }


}