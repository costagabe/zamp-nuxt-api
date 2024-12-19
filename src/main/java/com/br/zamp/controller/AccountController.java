package com.br.zamp.controller;

import com.br.zamp.config.dto.SelectOption;
import com.br.zamp.controller.specifications.AccountSpecification;
import com.br.zamp.domain.Account;
import com.br.zamp.dto.account.CreateAccountDTO;
import com.br.zamp.dto.account.ReadAndUpdateAccountDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import com.br.zamp.service.AccountService;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_ACCOUNTS, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_ACCOUNTS, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_ACCOUNTS, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_ACCOUNTS, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_ACCOUNTS, method = CrudMethod.DELETE)
})
public class AccountController
    extends CrudController<
        Account, CreateAccountDTO, ReadAndUpdateAccountDTO, AccountSpecification> {
  private final AccountService accountService;

  @GetMapping("/select-list")
  public ResponseEntity<Set<SelectOption<UUID>>> getAccountsSelect(AccountSpecification spec) {
    return ResponseEntity.ok(accountService.getAccountsSelect(spec));
  }
}
