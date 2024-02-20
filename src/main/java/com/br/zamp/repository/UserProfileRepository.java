package com.br.zamp.repository;

import com.br.zamp.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, UUID>, JpaSpecificationExecutor<UserProfile> {

  @Query("select up from UserProfile up where up.level <= :level")
  Set<UserProfile> findUserProfileByUserProfileLevel(@Param("level") Integer level);

//  @Query("SELECT u FROM User u WHERE u NOT IN (SELECT u2 FROM UserProfile p JOIN p.users u2 WHERE p.id = :profileId)")
//  Page<User> findUnlinkedUsers(@Param("profileId") Long id, Pageable pageable);
//
//  @Query("SELECT p from UserProfile p WHERE p.id IN (:ids)")
//  List<UserProfile> findByIds(@Param("ids") List<Long> ids);
//
//  @Query("SELECT u from User u join u.userProfiles p WHERE p.id = :id")
//  Page<User> findLinkedUsers(@Param("id") Long id, Pageable pageable);
}
