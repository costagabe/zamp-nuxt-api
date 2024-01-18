package com.br.zamp.web;

import com.br.zamp.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("auth")
    public String authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }
}
