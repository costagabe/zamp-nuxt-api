package com.br.zamp.repository;

import com.br.zamp.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>, JpaSpecificationExecutor<Account> {

  //  @Query("SELECT sum(e.value) FROM Account a join a.entries e on e.type = 'IN' WHERE a.id = :accountId")
  @Query("SELECT (SUM(CASE WHEN e.type = 'IN' THEN e.value ELSE 0 END) - SUM(CASE WHEN e.type = 'OUT' THEN e.value ELSE 0 END)) FROM Account a JOIN a.entries e WHERE a.id = :accountId")
  Float getBalance(@Param("accountId") UUID accountId);
}
