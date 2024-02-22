package com.br.zamp.mapper;

import com.br.zamp.domain.Document;
import com.br.zamp.dto.document.CreateDocumentDTO;
import com.br.zamp.dto.document.ReadAndUpdateDocumentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface DocumentMapper extends BaseMapper<Document, CreateDocumentDTO, ReadAndUpdateDocumentDTO> {
  DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);
}