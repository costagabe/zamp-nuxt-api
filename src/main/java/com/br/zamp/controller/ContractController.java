package com.br.zamp.controller;

import com.br.zamp.controller.specifications.ContractSpecification;
import com.br.zamp.domain.Contract;
import com.br.zamp.dto.contract.CreateContractDTO;
import com.br.zamp.dto.contract.ReadAndUpdateContractDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contracts")
@CrudPermission({
    @CrudPermissionType(permission = Permission.CREATE_CONTRACTS, method = CrudMethod.CREATE),
    @CrudPermissionType(permission = Permission.UPDATE_CONTRACTS, method = CrudMethod.UPDATE),
    @CrudPermissionType(permission = Permission.READ_CONTRACTS, method = CrudMethod.READ),
    @CrudPermissionType(permission = Permission.READ_ALL_CONTRACTS, method = CrudMethod.READ_ALL),
    @CrudPermissionType(permission = Permission.DELETE_CONTRACTS, method = CrudMethod.DELETE)
})
public class ContractController extends CrudController<Contract, CreateContractDTO, ReadAndUpdateContractDTO, ContractSpecification> {
}
