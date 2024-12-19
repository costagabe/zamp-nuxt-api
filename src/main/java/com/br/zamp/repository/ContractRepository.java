package com.br.zamp.repository;

import com.br.zamp.domain.Contract;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository
    extends JpaRepository<Contract, UUID>, JpaSpecificationExecutor<Contract> {}
