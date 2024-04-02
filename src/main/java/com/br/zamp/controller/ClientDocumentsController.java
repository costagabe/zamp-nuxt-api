package com.br.zamp.controller;

import com.br.zamp.domain.Document;
import com.br.zamp.dto.client.document.CreateClientDocumentDTO;
import com.br.zamp.dto.client.document.ReadAndUpdateClientDocumentDTO;
import com.br.zamp.dto.utils.CustomPage;
import com.br.zamp.enums.Permission;
import com.br.zamp.mapper.ClientDocumentMapper;
import com.br.zamp.security.annotation.CrudMethod;
import com.br.zamp.security.annotation.CrudPermission;
import com.br.zamp.security.annotation.CrudPermissionType;
import com.br.zamp.service.ClientDocumentService;
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
@RequestMapping("/clients/{clientId}/documents")
@CrudPermission({
  @CrudPermissionType(permission = Permission.CREATE_CLIENT_DOCUMENTS, method = CrudMethod.CREATE),
  @CrudPermissionType(permission = Permission.UPDATE_CLIENT_DOCUMENTS, method = CrudMethod.UPDATE),
  @CrudPermissionType(permission = Permission.READ_CLIENT_DOCUMENTS, method = CrudMethod.READ),
  @CrudPermissionType(permission = Permission.READ_ALL_CLIENT_DOCUMENTS, method = CrudMethod.READ_ALL),
  @CrudPermissionType(permission = Permission.DELETE_CLIENT_DOCUMENTS, method = CrudMethod.DELETE)
})
public class ClientDocumentsController {
  private final ClientDocumentService clientDocumentService;
  private final ClientDocumentMapper clientDocumentMapper;

  @PostMapping
  public ResponseEntity<ReadAndUpdateClientDocumentDTO> create(@PathVariable("clientId") UUID clientId, @Valid @RequestBody CreateClientDocumentDTO dto) {
    Document mapped = clientDocumentMapper.createDTOToEntity(dto);
    Document created = clientDocumentService.create(clientId, mapped);
    ReadAndUpdateClientDocumentDTO response = clientDocumentMapper.toReadAndUpdateDTO(created);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping
  public ResponseEntity<CustomPage<ReadAndUpdateClientDocumentDTO>> findAll(@PathVariable("clientId") UUID clientId, Pageable pageable) {
    var entities = clientDocumentService.findAll(clientId, pageable);
    Page<ReadAndUpdateClientDocumentDTO> pageDto = entities.map(clientDocumentMapper::toReadAndUpdateDTO);
    CustomPage<ReadAndUpdateClientDocumentDTO> page = new CustomPage<>(pageDto);
    return ResponseEntity.ok(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReadAndUpdateClientDocumentDTO> findById(@PathVariable UUID id) {
    Document entity = clientDocumentService.findById(id);
    ReadAndUpdateClientDocumentDTO response = clientDocumentMapper.toReadAndUpdateDTO(entity);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@Valid @RequestBody ReadAndUpdateClientDocumentDTO dto, @PathVariable UUID id) {
    Document mapped = clientDocumentService.findById(id);
    clientDocumentMapper.readAndUpdateDTOToEntity(dto, mapped);
    clientDocumentService.update(mapped);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
