package com.br.zamp.controller;

import com.br.zamp.controller.specifications.UserProfileSpecification;
import com.br.zamp.domain.UserProfile;
import com.br.zamp.dto.profile.CreateUserProfileDTO;
import com.br.zamp.dto.profile.ReadAndUpdateUserProfileDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
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
public class UserProfileController extends CrudController<UserProfile, CreateUserProfileDTO, ReadAndUpdateUserProfileDTO, UserProfileSpecification> {
}
