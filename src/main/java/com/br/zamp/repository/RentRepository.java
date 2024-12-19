package com.br.zamp.repository;

import com.br.zamp.domain.Rent;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, UUID>, JpaSpecificationExecutor<Rent> {}
