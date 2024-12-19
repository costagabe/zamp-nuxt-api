package com.br.zamp.mapper;

import com.br.zamp.domain.Company;
import com.br.zamp.dto.company.CreateCompanyDTO;
import com.br.zamp.dto.company.ReadAndUpdateCompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CompanyMapper
    extends BaseMapper<Company, CreateCompanyDTO, ReadAndUpdateCompanyDTO> {
  CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

  @Mapping(target = "id", ignore = true)
  Company copy(Company entity);
}