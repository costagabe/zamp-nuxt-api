package com.br.zamp.service.impl;

import com.br.zamp.domain.Client;
import com.br.zamp.domain.Document;
import com.br.zamp.exceptions.ObjectNotFoundException;
import com.br.zamp.exceptions.ValidationException;
import com.br.zamp.repository.DocumentRepository;
import com.br.zamp.service.ClientDocumentService;
import com.br.zamp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientDocumentServiceImpl implements ClientDocumentService {
  private final DocumentRepository documentRepository;
  private final ClientService clientService;

  @Override
  public Document create(UUID id, Document document) {
    Client client = clientService.findById(id);
    document.setClient(client);

    documentRepository.save(document);

    client.getDocuments().add(document);
    return document;
  }

  @Override
  public void update(Document document) {
    if(document.getPublicPath() == null || document.getPublicPath().isEmpty() || document.getPublicPath().isBlank()) {
      throw new ValidationException("Não foi possível encontrar o caminho do arquivo.", "publicPath", "Campo não pode ser vazio.");
    }
    documentRepository.save(document);
  }

  @Override
  public Document findById(UUID uuid) {
  return documentRepository
    .findById(uuid)
    .orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado"));
  }

  @Override
  public Page<Document> findAll(UUID clientId, Pageable pageable) {

    return documentRepository.findAllByClientId(clientId, pageable);
  }

  @Override
  public void delete(UUID uuid) {

  }
}
