package com.br.zamp.mapper;

import org.mapstruct.factory.Mappers;

public interface BaseMapper<Entity, CreateDTO, ReadAndUpdateDTO> {
  BaseMapper<?, ?, ?> INSTANCE = Mappers.getMapper(BaseMapper.class);

  CreateDTO toCreateDTO(Entity entity);

  ReadAndUpdateDTO toReadAndUpdateDTO(Entity entity);

  Entity createDTOToEntity(CreateDTO dto);

  Entity readAndUpdateDTOToEntity(ReadAndUpdateDTO dto);
}
