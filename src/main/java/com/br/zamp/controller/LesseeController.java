package com.br.zamp.controller;

import com.br.zamp.controller.specifications.LesseeSpecification;
import com.br.zamp.domain.Lessee;
import com.br.zamp.dto.lessee.CreateLesseeDTO;
import com.br.zamp.dto.lessee.ReadAndUpdateLesseeDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lesees")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_LESSEES, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_LESSEES, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_LESSEES, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_LESSEES, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_LESSEES, method = CrudMethod.DELETE)
})
public class LesseeController extends CrudController<Lessee, CreateLesseeDTO, ReadAndUpdateLesseeDTO, LesseeSpecification> {
}
