package com.br.zamp.dto.client.document;

import com.br.zamp.domain.enums.DocumentType;

public record CreateClientDocumentDTO(String name, DocumentType type, String publicPath) {
}
