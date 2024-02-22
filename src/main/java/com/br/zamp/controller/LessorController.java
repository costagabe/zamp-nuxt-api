package com.br.zamp.controller;

import com.br.zamp.controller.specifications.LessorSpecification;
import com.br.zamp.domain.Lessor;
import com.br.zamp.dto.lessor.CreateLessorDTO;
import com.br.zamp.dto.lessor.ReadAndUpdateLessorDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lessors")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_LESSORS, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_LESSORS, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_LESSORS, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_LESSORS, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_LESSORS, method = CrudMethod.DELETE)
})
public class LessorController extends CrudController<Lessor, CreateLessorDTO, ReadAndUpdateLessorDTO, LessorSpecification> {
}
