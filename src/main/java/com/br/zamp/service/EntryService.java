package com.br.zamp.service;

import com.br.zamp.domain.Entry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EntryService extends CrudService<Entry> {
  Page<Entry> findAll(Pageable pageable, UUID accountId);
}