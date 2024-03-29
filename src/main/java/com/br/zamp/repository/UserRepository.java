package com.br.zamp.repository;

import com.br.zamp.domain.Company;
import com.br.zamp.domain.User;
import com.br.zamp.domain.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {

  @EntityGraph(attributePaths = {"userProfiles"})
  Optional<User> findByEmail(String email);

  @Query("SELECT up FROM User u join u.userProfiles up WHERE u.id = :userId")
  List<UserProfile> getUserProfilesByUserId(@Param("userId") UUID id);

  @Query("SELECT x FROM User u join u.userProfiles x WHERE u.id = :userId")
  Page<UserProfile> getUserProfilesByUserIdAndPage(@Param("userId") UUID id, Pageable pageRequest);

  @Query("SELECT c FROM User u join u.companies c WHERE u.id = :userId")
  Page<Company> getUserCompanies(@Param("userId") UUID id, Pageable pageable);
}
