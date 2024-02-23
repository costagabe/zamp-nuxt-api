package com.br.zamp.domain;


import com.br.zamp.domain.enums.UserSituation;
import com.br.zamp.enums.Permission;
import com.br.zamp.enums.PermissionType;
import com.br.zamp.security.UserAuthAuthority;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true, exclude = {"userProfiles"})
@Entity
@Table(name = "users")
@Data
@SQLDelete(sql = "UPDATE users SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class User extends Base {

  private String name;

  private String email;

  private String password;

  @Enumerated(EnumType.STRING)
  private UserSituation situation;

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<UserProfile> userProfiles = new HashSet<>();

  @ManyToMany(mappedBy = "users")
  private Set<Company> companies = new HashSet<>();

  public UserProfile getMaxUserProfileLevel() {
    return userProfiles.stream().max(Comparator.comparing(UserProfile::getLevel)).orElse(new UserProfile());
  }

  public Set<UserAuthAuthority> fetchAndFlattenAuthorities() {
    return userProfiles
      .stream()
      .map(up -> new UserAuthAuthority(up.getName().toUpperCase()))
      .collect(Collectors.toSet());
  }

  public Set<Permission> fetchAndFlattenPermissions() {
    Set<Permission> permissions = getPermissionsFromUserProfile();

    var hasAllPermission = permissions.stream().anyMatch(permission -> permission == Permission.ALL);

    Set<Permission> ret = new HashSet<>(permissions);

    if (hasAllPermission) {
      ret = new HashSet<>(List.of(Permission.values()));
    }

    return ret;
  }

  public Set<GrantedAuthority> fetchAndFlattenGrantedAuthorities() {
    Set<Permission> permissions = fetchAndFlattenPermissions();
    Set<GrantedAuthority> ret = new HashSet<>(permissions);

    ret.add(new SimpleGrantedAuthority(String.format("LEVEL_%s", Optional.ofNullable(getMaxUserProfileLevel()).map(UserProfile::getLevel).orElse(0))));

    return ret;
  }

  private Set<Permission> getPermissionsFromUserProfile() {
    return userProfiles
      .stream()
      .flatMap(userProfile -> userProfile.getPermissions().stream())
      .collect(Collectors.toSet());
  }

  public Set<Permission> getUserMenus() {
    Set<Permission> permissions = fetchAndFlattenPermissions();

    Set<Permission> ret = new HashSet<>(permissions);

    return ret.stream()
      .filter(permission -> permission.getType().equals(PermissionType.MENU))
      .collect(Collectors.toSet());
  }

  @Override
  public String toString() {
    return "User{" +
      "name='" + name + '\'' +
      ", email='" + email + '\'' +
      ", password='" + password + '\'' +
      ", situation=" + situation +
      '}';
  }

}