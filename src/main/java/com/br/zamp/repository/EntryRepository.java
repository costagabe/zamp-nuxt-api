package com.br.zamp.repository;

import com.br.zamp.domain.Entry;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository
    extends JpaRepository<Entry, UUID>, JpaSpecificationExecutor<Entry> {

  @Query(
      "SELECT e FROM Entry e WHERE e.financialAccount.id = :accountId or e.classificationAccount.id"
          + " = :accountId")
  Page<Entry> findAllByAccountId(@Param("accountId") UUID accountId, Pageable pageable);
}