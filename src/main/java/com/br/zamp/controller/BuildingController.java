package com.br.zamp.controller;

import com.br.zamp.controller.specifications.BuildingSpecification;
import com.br.zamp.domain.Building;
import com.br.zamp.dto.building.CreateBuildingDTO;
import com.br.zamp.dto.building.ReadAndUpdateBuildingDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/buildings")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_BUILDINGS, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_BUILDINGS, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_BUILDINGS, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_BUILDINGS, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_BUILDINGS, method = CrudMethod.DELETE)
})
public class BuildingController
    extends CrudController<
        Building, CreateBuildingDTO, ReadAndUpdateBuildingDTO, BuildingSpecification> {}
