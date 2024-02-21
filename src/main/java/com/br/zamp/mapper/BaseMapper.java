package com.br.zamp.mapper;

import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public interface BaseMapper<Entity, CreateDTO, ReadAndUpdateDTO> {
  BaseMapper<?, ?, ?> INSTANCE = Mappers.getMapper(BaseMapper.class);

  ReadAndUpdateDTO toReadAndUpdateDTO(Entity entity);

  Entity createDTOToEntity(CreateDTO dto);

  Entity readAndUpdateDTOToEntity(ReadAndUpdateDTO dto);

  void readAndUpdateDTOToEntity(ReadAndUpdateDTO dto, @MappingTarget Entity entity);

  void toEntity(ReadAndUpdateDTO dto, @MappingTarget Entity entity);

  void createDTOToEntity(CreateDTO dto, @MappingTarget Entity entity);

  ReadAndUpdateDTO toDTO(Entity entity);
}
