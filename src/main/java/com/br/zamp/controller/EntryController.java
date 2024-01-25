package com.br.zamp.controller;

import com.br.zamp.controller.specifications.EntrySpecification;
import com.br.zamp.domain.Entry;
import com.br.zamp.dto.entry.CreateEntryDTO;
import com.br.zamp.dto.entry.ReadAndUpdateEntryDTO;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/entries")
@CrudPermission({
    @CrudPermissionType(permission = Permission.CREATE_ENTRIES, method = CrudMethod.CREATE),
    @CrudPermissionType(permission = Permission.UPDATE_ENTRIES, method = CrudMethod.UPDATE),
    @CrudPermissionType(permission = Permission.READ_ENTRIES, method = CrudMethod.READ),
    @CrudPermissionType(permission = Permission.READ_ALL_ENTRIES, method = CrudMethod.READ_ALL),
    @CrudPermissionType(permission = Permission.DELETE_ENTRIES, method = CrudMethod.DELETE)
})
public class EntryController extends CrudController<Entry, CreateEntryDTO, ReadAndUpdateEntryDTO, EntrySpecification> {
}
