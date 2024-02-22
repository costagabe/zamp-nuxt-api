package com.br.zamp.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class SecurityUtil {
  private static final String ACCESS_TOKEN = "accessToken";

  public static String extractTokenFromCookies(HttpServletRequest request) {
    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        if (cookie.getName().equals(ACCESS_TOKEN)) {
          return cookie.getValue();
        }
      }
    }
    return null;
  }
}
