package com.br.zamp.repository;

import com.br.zamp.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Company> {

    @Query("SELECT DISTINCT c FROM User u JOIN u.companies c WHERE u.id = :userId")
    List<Company> getMenus(@Param("userId") Long userId);

}
