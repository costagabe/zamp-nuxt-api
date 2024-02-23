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
import java.util.List;

@Component
@Setter(onMethod_ = @Autowired)
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private static final List<String[]> allowedRoutes = List.of(new String[]{"/auth", "POST"}, new String[]{"/auth/logout", "GET"});
  private static final String AUTHORIZATION = "Authorization";
  JpaUserDetailsService userDetailsServiceImpl;

  @Override
  protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse
    response, @NonNull FilterChain filterChain) throws ServletException, IOException {
    var url = request.getRequestURI();
    var method = request.getMethod();

    if (allowedRoutes.stream().anyMatch(route -> route[0].equals(url) && route[1].equals(method))) {
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