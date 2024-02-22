package com.br.zamp.mapper;

import com.br.zamp.domain.Lessor;
import com.br.zamp.dto.lessor.CreateLessorDTO;
import com.br.zamp.dto.lessor.ReadAndUpdateLessorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface LessorMapper extends BaseMapper<Lessor, CreateLessorDTO, ReadAndUpdateLessorDTO> {
  LessorMapper INSTANCE = Mappers.getMapper(LessorMapper.class);
}