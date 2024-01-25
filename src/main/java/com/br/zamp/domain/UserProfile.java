package com.br.zamp.domain;

import com.br.zamp.enums.Permission;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = {"users"})
@Entity
@Data
public class UserProfile extends Base {

  private String name;

  private Integer level;

  @ManyToMany
  @JoinTable(name = "profile_user", joinColumns = @JoinColumn(name = "profile_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users = new HashSet<>();

  @ManyToMany(mappedBy = "userProfiles")
  private Set<Company> companies;

  @CollectionTable(joinColumns = {@JoinColumn(name = "user_profile_id", referencedColumnName = "id", nullable = false)}, name = "user_profile_permission")
  @Column(name = "permission", nullable = false)
  @ElementCollection(fetch = FetchType.LAZY)
  @Enumerated(EnumType.STRING)
  private Set<Permission> permissions = new HashSet<>();

  public String getName() {
    return String.format("ROLE_%s", name);
  }
}