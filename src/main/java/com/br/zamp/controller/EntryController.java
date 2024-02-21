package com.br.zamp.controller;

import com.br.zamp.domain.Entry;
import com.br.zamp.dto.entry.CreateEntryDTO;
import com.br.zamp.dto.entry.ReadAndUpdateEntryDTO;
import com.br.zamp.dto.utils.CustomPage;
import com.br.zamp.enums.Permission;
import com.br.zamp.mapper.EntryMapper;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import com.br.zamp.service.EntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts/{accountId}/entries")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_ENTRIES, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_ENTRIES, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_ENTRIES, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_ENTRIES, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_ENTRIES, method = CrudMethod.DELETE)
})
public class EntryController {
  private final EntryService service;
  private final EntryMapper mapper;

  @PostMapping
  public ResponseEntity<ReadAndUpdateEntryDTO> create(@PathVariable UUID accountId, @Valid @RequestBody CreateEntryDTO dto) {
    Entry mapped = mapper.createDTOToEntity(dto, accountId);
    Entry created = service.create(mapped);
    ReadAndUpdateEntryDTO response = mapper.toReadAndUpdateDTO(created);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@Valid @RequestBody ReadAndUpdateEntryDTO dto, @PathVariable UUID id) {
    Entry mapped = service.findById(id);
    mapper.readAndUpdateDTOToEntity(dto, mapped);
    service.update(mapped);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReadAndUpdateEntryDTO> findById(@PathVariable UUID id) {
    Entry entity = service.findById(id);
    ReadAndUpdateEntryDTO response = mapper.toReadAndUpdateDTO(entity);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  ResponseEntity<CustomPage<ReadAndUpdateEntryDTO>> findAll(
    @PathVariable UUID accountId,
    Pageable pageable
  ) {
    Page<Entry> entities = service.findAll(pageable, accountId);
    Page<ReadAndUpdateEntryDTO> page = entities.map(mapper::toReadAndUpdateDTO);
    CustomPage<ReadAndUpdateEntryDTO> response = new CustomPage<>(page);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<?> delete(@PathVariable UUID id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
