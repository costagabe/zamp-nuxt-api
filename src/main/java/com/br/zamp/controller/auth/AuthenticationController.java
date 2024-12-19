package com.br.zamp.controller.auth;

import com.br.zamp.security.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authService;
  private final AuthenticationManager authenticationManager;
  private final AuthenticatedUser authenticatedUser;

  @GetMapping
  public ResponseEntity<?> isAuth(HttpServletRequest request) {
    String token = SecurityUtil.extractTokenFromCookies(request);

    if (token == null) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    return ResponseEntity.ok(authenticatedUser.getMaxLevel());
  }

  @GetMapping("/logout")
  public ResponseEntity<?> logout(HttpServletResponse response) {
    ResponseCookie cookie =
        ResponseCookie.from("accessToken", "")
            .httpOnly(true)
            .secure(false)
            .path("/")
            .maxAge(Duration.ofDays(1))
            .build();

    response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

    return ResponseEntity.ok("User logged out successfully");
  }

  @PostMapping
  public ResponseEntity<?> login(
      @RequestBody AuthDTO.LoginRequest userLogin, HttpServletResponse response) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    AuthUser userDetails = (AuthUser) authentication.getPrincipal();

    String token = authService.authenticate(userDetails);

    AuthDTO.Response responseDTO = new AuthDTO.Response("User logged in successfully", token);

    ResponseCookie cookie =
        ResponseCookie.from("accessToken", token)
            .httpOnly(true)
            .secure(false)
            .path("/")
            .maxAge(Duration.ofDays(1))
            .build();

    response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

    return ResponseEntity.ok(responseDTO);
  }
}
