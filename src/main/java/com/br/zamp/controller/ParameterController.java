package com.br.zamp.controller;

import com.br.zamp.controller.specifications.ParameterSpecification;
import com.br.zamp.domain.Parameter;
import com.br.zamp.dto.parameter.CreateParameterDTO;
import com.br.zamp.dto.parameter.ReadAndUpdateParameterDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parameteres")
@CrudPermission({
    @CrudPermissionType(permission = Permission.CREATE_PARAMETERS, method = CrudMethod.CREATE),
    @CrudPermissionType(permission = Permission.UPDATE_PARAMETERS, method = CrudMethod.UPDATE),
    @CrudPermissionType(permission = Permission.READ_PARAMETERS, method = CrudMethod.READ),
    @CrudPermissionType(permission = Permission.READ_ALL_PARAMETERS, method = CrudMethod.READ_ALL),
    @CrudPermissionType(permission = Permission.DELETE_PARAMETERS, method = CrudMethod.DELETE)
})
public class ParameterController extends CrudController<Parameter, CreateParameterDTO, ReadAndUpdateParameterDTO, ParameterSpecification> {
}
