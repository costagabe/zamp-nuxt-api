package com.br.zamp.mapper;

import com.br.zamp.domain.Company;
import com.br.zamp.dto.company.CreateCompanyDTO;
import com.br.zamp.dto.company.ReadAndUpdateCompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends BaseMapper<Company, CreateCompanyDTO, ReadAndUpdateCompanyDTO> {
  CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
}