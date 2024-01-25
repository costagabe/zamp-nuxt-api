package com.br.zamp;

import com.br.zamp.controller.CrudController;
import com.br.zamp.controller.specifications.FileStorageSpecification;
import com.br.zamp.domain.FileStorage;
import com.br.zamp.dto.file.CreateFileStorageDTO;
import com.br.zamp.dto.file.ReadAndUpdateFileStorageDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/file-storages")
@CrudPermission({
    @CrudPermissionType(permission = Permission.CREATE_FILE_STORAGES, method = CrudMethod.CREATE),
    @CrudPermissionType(permission = Permission.UPDATE_FILE_STORAGES, method = CrudMethod.UPDATE),
    @CrudPermissionType(permission = Permission.READ_FILE_STORAGES, method = CrudMethod.READ),
    @CrudPermissionType(permission = Permission.READ_ALL_FILE_STORAGES, method = CrudMethod.READ_ALL),
    @CrudPermissionType(permission = Permission.DELETE_FILE_STORAGES, method = CrudMethod.DELETE)
})
public class FileStorageController extends CrudController<FileStorage, CreateFileStorageDTO, ReadAndUpdateFileStorageDTO, FileStorageSpecification> {
}
