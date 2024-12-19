package com.br.zamp.controller;

import com.br.zamp.controller.specifications.AddressSpecification;
import com.br.zamp.domain.Address;
import com.br.zamp.dto.address.CreateAddressDTO;
import com.br.zamp.dto.address.ReadAndUpdateAddressDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_ADDRESSES, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_ADDRESSES, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_ADDRESSES, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_ADDRESSES, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_ADDRESSES, method = CrudMethod.DELETE)
})
public class AddressController
    extends CrudController<
        Address, CreateAddressDTO, ReadAndUpdateAddressDTO, AddressSpecification> {}
