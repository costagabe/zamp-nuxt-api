package com.br.zamp.mapper;

import com.br.zamp.domain.Document;
import com.br.zamp.dto.client.document.CreateClientDocumentDTO;
import com.br.zamp.dto.client.document.ReadAndUpdateClientDocumentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ClientDocumentMapper
    extends BaseMapper<Document, CreateClientDocumentDTO, ReadAndUpdateClientDocumentDTO> {
  ClientDocumentMapper INSTANCE = Mappers.getMapper(ClientDocumentMapper.class);
}