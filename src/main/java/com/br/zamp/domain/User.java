package com.br.zamp.domain;


import com.br.zamp.domain.enums.UserSituation;
import com.br.zamp.enums.Permission;
import com.br.zamp.enums.PermissionType;
import com.br.zamp.security.UserAuthAuthority;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
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

  @ManyToMany(mappedBy = "users")
  private Set<UserProfile> userProfiles = new HashSet<>();

  @ManyToMany(mappedBy = "users")
  private Set<Company> companies = new HashSet<>();

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
    Set<Permission> permissions = getPermissionsFromUserProfile();

    var hasAllPermission = permissions.stream().anyMatch(permission -> permission == Permission.ALL);

    Set<GrantedAuthority> ret = new HashSet<>(permissions);

    if (hasAllPermission) {
      ret = new HashSet<>(List.of(Permission.values()));
    }

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
    Set<Permission> permissions = getPermissionsFromUserProfile();

    var hasAllPermission = permissions.stream().anyMatch(permission -> permission == Permission.ALL);

    Set<Permission> ret = new HashSet<>(permissions);

    if (hasAllPermission) {
      ret = new HashSet<>(List.of(Permission.values()));
    }
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