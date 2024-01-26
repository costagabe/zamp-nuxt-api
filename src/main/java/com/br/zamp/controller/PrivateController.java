package com.br.zamp.controller;

import com.br.zamp.security.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private")
@RequiredArgsConstructor
public class PrivateController {
  @GetMapping
  @PreAuthorize("hasAuthority('PERM_ENTRIES_MENU')")
  public String getMessage() {
    return "Hello from private API controller";
  }

  @GetMapping("/a")
  public String getMessagea(AuthenticatedUser authenticatedUser) {
    var auth = authenticatedUser.getUser();
    return "Hello from private API controller" + auth.getName();
  }
}
