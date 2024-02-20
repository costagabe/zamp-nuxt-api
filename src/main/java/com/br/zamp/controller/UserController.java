package com.br.zamp.controller;

import com.br.zamp.controller.specifications.UserSpecification;
import com.br.zamp.domain.User;
import com.br.zamp.dto.user.CreateUserDTO;
import com.br.zamp.dto.user.ReadAndUpdateUserDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.AuthenticatedUser;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@CrudPermission({
    @CrudPermissionType(permission = Permission.CREATE_USERS, method = CrudMethod.CREATE),
    @CrudPermissionType(permission = Permission.UPDATE_USERS, method = CrudMethod.UPDATE),
    @CrudPermissionType(permission = Permission.READ_USERS, method = CrudMethod.READ),
    @CrudPermissionType(permission = Permission.READ_ALL_USERS, method = CrudMethod.READ_ALL),
    @CrudPermissionType(permission = Permission.DELETE_USERS, method = CrudMethod.DELETE)
})
public class UserController extends CrudController<User, CreateUserDTO, ReadAndUpdateUserDTO, UserSpecification> {

  private final AuthenticatedUser authenticatedUser;

  @GetMapping("/menus")
  public ResponseEntity<Set<Permission>> getUserMenus(  ) {
    return ResponseEntity.ok(authenticatedUser.getUser().getUserMenus());
  }

}
