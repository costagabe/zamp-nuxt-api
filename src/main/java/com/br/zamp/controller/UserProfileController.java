package com.br.zamp.controller;

import com.br.zamp.config.dto.SelectOption;
import com.br.zamp.controller.specifications.UserProfileSpecification;
import com.br.zamp.domain.UserProfile;
import com.br.zamp.dto.permission.PermissionDTO;
import com.br.zamp.dto.profile.CreateUserProfileDTO;
import com.br.zamp.dto.profile.ReadAndUpdateUserProfileDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.AuthenticatedUser;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import com.br.zamp.service.UserProfileService;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-profiles")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_USER_PROFILES, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_USER_PROFILES, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_USER_PROFILES, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_USER_PROFILES, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_USER_PROFILES, method = CrudMethod.DELETE)
})
public class UserProfileController
    extends CrudController<
        UserProfile, CreateUserProfileDTO, ReadAndUpdateUserProfileDTO, UserProfileSpecification> {

  private final UserProfileService userProfileService;
  private final AuthenticatedUser auth;

  @GetMapping("/select-list")
  public ResponseEntity<Set<SelectOption<UUID>>> getUserProfilesSelect() {
    return ResponseEntity.ok(userProfileService.getUserProfileSelectList(auth.getMaxLevel()));
  }

  @GetMapping("/permission-list")
  public ResponseEntity<Set<PermissionDTO>> getUserProfilePermissionList() {
    return ResponseEntity.ok(userProfileService.getUserProfilePermissionList(auth.getUser()));
  }
}
