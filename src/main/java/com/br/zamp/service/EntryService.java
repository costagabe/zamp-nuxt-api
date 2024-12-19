package com.br.zamp.service;

import com.br.zamp.domain.Entry;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EntryService extends CrudService<Entry> {
  Page<Entry> findAll(Pageable pageable, UUID accountId);
}