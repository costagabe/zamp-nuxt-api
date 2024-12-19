package com.br.zamp.repository;

import com.br.zamp.domain.Building;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository
    extends JpaRepository<Building, UUID>, JpaSpecificationExecutor<Building> {}
