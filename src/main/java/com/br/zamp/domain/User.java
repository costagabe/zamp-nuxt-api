package com.br.zamp.domain;


import com.br.zamp.domain.enums.UserSituation;
import com.br.zamp.domain.enums.UserType;
import com.br.zamp.enums.Permission;
import com.br.zamp.security.UserAuthAuthority;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true, exclude = {"userProfiles"})
@Entity
@Table(name = "users")
@Data
public class User extends Base {

  private String name;

  private String email;

  private String password;

  private UserSituation situation;

  @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
  private Set<UserProfile> userProfiles = new HashSet<>();

  @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
  private Set<Company> companies = new HashSet<>();

  @ManyToMany
  @JoinTable(name = "user_routine", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "routine_id"))
  private Set<Routine> routines;

  @Column(length = 20, nullable = false)
  @Enumerated(EnumType.STRING)
  private UserType type;


  public UserProfile getMaxUserProfileLevel() {
    return userProfiles.stream().max(Comparator.comparing(UserProfile::getLevel)).orElse(null);
  }

  public Set<UserAuthAuthority> fetchAndFlattenAuthorities() {
    return userProfiles
        .stream()
        .map(up -> new UserAuthAuthority(up.getName().toUpperCase()))
        .collect(Collectors.toSet());
  }

  public Set<GrantedAuthority> fetchAndFlattenPermissions() {
    Set<GrantedAuthority> permissions = userProfiles
        .stream()
        .flatMap(userProfile -> userProfile.getPermissions().stream())
        .collect(Collectors.toSet());

    var hasAllPermission = permissions.stream().anyMatch(permission -> permission == Permission.ALL);

    if (hasAllPermission) {
      return Set.of(Permission.values());
    }

    return permissions;
  }

}