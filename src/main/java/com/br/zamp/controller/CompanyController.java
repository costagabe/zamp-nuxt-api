package com.br.zamp.controller;

import com.br.zamp.controller.specifications.CompanySpecification;
import com.br.zamp.domain.Company;
import com.br.zamp.dto.company.CreateCompanyDTO;
import com.br.zamp.dto.company.ReadAndUpdateCompanyDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/companies")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_COMPANIES, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_COMPANIES, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_COMPANIES, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_COMPANIES, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_COMPANIES, method = CrudMethod.DELETE)
})
public class CompanyController extends CrudController<Company, CreateCompanyDTO, ReadAndUpdateCompanyDTO, CompanySpecification> {
}
