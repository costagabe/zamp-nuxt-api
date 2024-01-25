package com.br.zamp.repository;

import com.br.zamp.domain.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, UUID>, JpaSpecificationExecutor<Routine> {

}
