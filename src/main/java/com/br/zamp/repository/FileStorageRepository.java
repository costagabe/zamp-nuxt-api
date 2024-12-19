package com.br.zamp.repository;

import com.br.zamp.domain.FileStorage;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStorageRepository
    extends JpaRepository<FileStorage, UUID>, JpaSpecificationExecutor<FileStorage> {}
