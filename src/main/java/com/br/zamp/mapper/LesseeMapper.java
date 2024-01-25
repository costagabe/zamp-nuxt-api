package com.br.zamp.mapper;

import com.br.zamp.domain.Lessee;
import com.br.zamp.dto.lessee.CreateLesseeDTO;
import com.br.zamp.dto.lessee.ReadAndUpdateLesseeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LesseeMapper extends BaseMapper<Lessee, CreateLesseeDTO, ReadAndUpdateLesseeDTO> {
  LesseeMapper INSTANCE = Mappers.getMapper(LesseeMapper.class);
}