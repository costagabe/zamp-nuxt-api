package com.br.zamp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
    var auth = SecurityContextHolder.getContext().getAuthentication();
    return "Hello from private API controller";
  }

  @GetMapping("/a")
  public String getMessagea() {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    return "Hello from private API controller";
  }
}
