package com.br.zamp.controller;

import com.br.zamp.controller.specifications.DocumentSpecification;
import com.br.zamp.domain.Document;
import com.br.zamp.dto.document.CreateDocumentDTO;
import com.br.zamp.dto.document.ReadAndUpdateDocumentDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/documents")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_DOCUMENTS, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_DOCUMENTS, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_DOCUMENTS, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_DOCUMENTS, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_DOCUMENTS, method = CrudMethod.DELETE)
})
public class DocumentController
    extends CrudController<
        Document, CreateDocumentDTO, ReadAndUpdateDocumentDTO, DocumentSpecification> {}
