package com.br.zamp.dto.client.document;

import com.br.zamp.domain.enums.DocumentType;
import java.util.UUID;

public record ReadAndUpdateClientDocumentDTO(
    UUID id, String name, DocumentType type, String publicPath) {}
