package com.br.zamp.mapper;

import com.br.zamp.domain.Building;
import com.br.zamp.dto.building.CreateBuildingDTO;
import com.br.zamp.dto.building.ReadAndUpdateBuildingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BuildingMapper extends BaseMapper<Building, CreateBuildingDTO, ReadAndUpdateBuildingDTO> {
  BuildingMapper INSTANCE = Mappers.getMapper(BuildingMapper.class);
}