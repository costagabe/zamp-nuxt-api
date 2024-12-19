package com.br.zamp.service;

import com.br.zamp.domain.Document;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientDocumentService {

  Document create(UUID clientId, Document document);

  void update(Document document);

  Document findById(UUID uuid);

  Page<Document> findAll(UUID clientId, Pageable pageable);

  void delete(UUID uuid);
}
