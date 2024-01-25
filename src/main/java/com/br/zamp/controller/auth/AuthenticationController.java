package com.br.zamp.controller.auth;

import com.br.zamp.security.AuthDTO;
import com.br.zamp.security.AuthUser;
import com.br.zamp.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authService;
  private final AuthenticationManager authenticationManager;

  @PostMapping("auth")
  public ResponseEntity<?> login(@RequestBody AuthDTO.LoginRequest userLogin) {
    Authentication authentication =
        authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(
                userLogin.username(),
                userLogin.password())
            );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    AuthUser userDetails = (AuthUser) authentication.getPrincipal();

    String token = authService.authenticate(userDetails);

    AuthDTO.Response response = new AuthDTO.Response("User logged in successfully", token);

    return ResponseEntity.ok(response);
  }
}
