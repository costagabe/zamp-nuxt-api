package com.br.zamp.controller;


import com.br.zamp.controller.specifications.ClientSpecification;
import com.br.zamp.domain.Client;
import com.br.zamp.dto.client.CreateClientDTO;
import com.br.zamp.dto.client.ReadAndUpdateClientDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_CLIENTS, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_CLIENTS, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_CLIENTS, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_CLIENTS, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_CLIENTS, method = CrudMethod.DELETE)
})
public class ClientController extends CrudController<Client, CreateClientDTO, ReadAndUpdateClientDTO, ClientSpecification> {
}
