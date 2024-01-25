package com.br.zamp.controller;

import com.br.zamp.controller.specifications.UserSpecification;
import com.br.zamp.domain.User;
import com.br.zamp.dto.CreateUserDTO;
import com.br.zamp.dto.ReadAndUpdateUserDTO;
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
    @CrudPermissionType(permission = Permission.CREATE_USER, method = CrudMethod.CREATE, level = 10),
    @CrudPermissionType(permission = Permission.UPDATE_USER, method = CrudMethod.UPDATE),
    @CrudPermissionType(permission = Permission.READ_USER, method = CrudMethod.READ, level = 1000),
    @CrudPermissionType(permission = {Permission.READ_USER, Permission.COMPANIES_MENU}, method = CrudMethod.READ_ALL),
    @CrudPermissionType(permission = Permission.DELETE_USER, method = CrudMethod.DELETE)
})
public class UserController extends CrudController<User, CreateUserDTO, ReadAndUpdateUserDTO, UserSpecification> {
}
