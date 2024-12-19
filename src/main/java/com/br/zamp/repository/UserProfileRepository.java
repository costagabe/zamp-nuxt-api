package com.br.zamp.repository;

import com.br.zamp.domain.UserProfile;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository
    extends JpaRepository<UserProfile, UUID>, JpaSpecificationExecutor<UserProfile> {

  @Query("select up from UserProfile up where up.level <= :level")
  Set<UserProfile> findUserProfileByUserProfileLevel(@Param("level") Integer level);

  Set<UserProfile> findByIdIn(Set<UUID> ids);
}
