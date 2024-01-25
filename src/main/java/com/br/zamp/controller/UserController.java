package com.br.zamp.controller;

import com.br.zamp.controller.specifications.UserSpecification;
import com.br.zamp.domain.User;
import com.br.zamp.dto.user.CreateUserDTO;
import com.br.zamp.dto.user.ReadAndUpdateUserDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@CrudPermission({
    @CrudPermissionType(permission = Permission.CREATE_USER, method = CrudMethod.CREATE),
    @CrudPermissionType(permission = Permission.UPDATE_USER, method = CrudMethod.UPDATE),
    @CrudPermissionType(permission = Permission.READ_USER, method = CrudMethod.READ),
    @CrudPermissionType(permission = Permission.READ_ALL_USER, method = CrudMethod.READ_ALL),
    @CrudPermissionType(permission = Permission.DELETE_USER, method = CrudMethod.DELETE)
})
public class UserController extends CrudController<User, CreateUserDTO, ReadAndUpdateUserDTO, UserSpecification> {
}
