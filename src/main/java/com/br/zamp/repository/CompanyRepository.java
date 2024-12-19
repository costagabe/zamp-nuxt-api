package com.br.zamp.repository;

import com.br.zamp.domain.Company;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository
    extends JpaRepository<Company, UUID>, JpaSpecificationExecutor<Company> {}
