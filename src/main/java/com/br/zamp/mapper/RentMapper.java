package com.br.zamp.mapper;

import com.br.zamp.domain.Rent;
import com.br.zamp.dto.rent.CreateRentDTO;
import com.br.zamp.dto.rent.ReadAndUpdateRentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface RentMapper extends BaseMapper<Rent, CreateRentDTO, ReadAndUpdateRentDTO> {
  RentMapper INSTANCE = Mappers.getMapper(RentMapper.class);
}