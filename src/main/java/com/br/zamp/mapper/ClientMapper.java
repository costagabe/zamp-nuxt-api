package com.br.zamp.mapper;

import com.br.zamp.domain.Client;
import com.br.zamp.dto.client.CreateClientDTO;
import com.br.zamp.dto.client.ReadAndUpdateClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ClientMapper extends BaseMapper<Client, CreateClientDTO, ReadAndUpdateClientDTO> {
  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
}