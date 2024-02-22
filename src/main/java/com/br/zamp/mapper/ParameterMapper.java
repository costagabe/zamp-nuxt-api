package com.br.zamp.mapper;

import com.br.zamp.domain.Parameter;
import com.br.zamp.dto.parameter.CreateParameterDTO;
import com.br.zamp.dto.parameter.ReadAndUpdateParameterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ParameterMapper extends BaseMapper<Parameter, CreateParameterDTO, ReadAndUpdateParameterDTO> {
  ParameterMapper INSTANCE = Mappers.getMapper(ParameterMapper.class);
}