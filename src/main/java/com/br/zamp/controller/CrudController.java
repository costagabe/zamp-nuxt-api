package com.br.zamp.controller;

import com.br.zamp.domain.Base;
import com.br.zamp.dto.utils.CustomPage;
import com.br.zamp.mapper.BaseMapper;
import com.br.zamp.service.CrudService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Setter(onMethod_ = @Autowired)
public abstract class CrudController<Entity extends Base, CreateDTO, ReadAndUpdateDTO, Spec extends Specification<Entity>> {

  protected CrudService<Entity> service;
  protected BaseMapper<Entity, CreateDTO, ReadAndUpdateDTO> dtoMapper;

  @PostMapping
  public ResponseEntity<ReadAndUpdateDTO> create(@RequestBody CreateDTO dto) {
    Entity mapped = dtoMapper.createDTOToEntity(dto);
    Entity created = service.create(mapped);
    ReadAndUpdateDTO response = dtoMapper.toReadAndUpdateDTO(created);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PutMapping
  public ResponseEntity<?> update(@RequestBody ReadAndUpdateDTO dto) {
    Entity mapped = dtoMapper.readAndUpdateDTOToEntity(dto);
    Entity updated = service.create(mapped);
    return ResponseEntity.status(HttpStatus.OK).body(updated);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReadAndUpdateDTO> findById(@PathVariable UUID id) {
    ReadAndUpdateDTO response = dtoMapper.toReadAndUpdateDTO(service.findById(id));
    return ResponseEntity.ok(response);
  }

  @GetMapping
  ResponseEntity<CustomPage<ReadAndUpdateDTO>> findAllBySpec(Spec spec, Pageable pageable){
    Page<Entity> entities = service.findAll(spec, pageable);
    Page<ReadAndUpdateDTO> page = entities.map(dtoMapper::toReadAndUpdateDTO);
    CustomPage<ReadAndUpdateDTO> response = new CustomPage<>(page);
    return ResponseEntity.ok(response) ;
  }

  @DeleteMapping("/{id}")
  ResponseEntity<?> delete(@PathVariable UUID id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

}