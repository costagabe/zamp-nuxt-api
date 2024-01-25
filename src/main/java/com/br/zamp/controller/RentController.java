package com.br.zamp.controller;

import com.br.zamp.controller.specifications.RentSpecification;
import com.br.zamp.domain.Rent;
import com.br.zamp.dto.rent.CreateRentDTO;
import com.br.zamp.dto.rent.ReadAndUpdateRentDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rents")
@CrudPermission({
    @CrudPermissionType(permission = Permission.CREATE_RENTS, method = CrudMethod.CREATE),
    @CrudPermissionType(permission = Permission.UPDATE_RENTS, method = CrudMethod.UPDATE),
    @CrudPermissionType(permission = Permission.READ_RENTS, method = CrudMethod.READ),
    @CrudPermissionType(permission = Permission.READ_ALL_RENTS, method = CrudMethod.READ_ALL),
    @CrudPermissionType(permission = Permission.DELETE_RENTS, method = CrudMethod.DELETE)
})
public class RentController extends CrudController<Rent, CreateRentDTO, ReadAndUpdateRentDTO, RentSpecification> {
}
