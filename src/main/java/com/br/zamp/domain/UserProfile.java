package com.br.zamp.domain;

import com.br.zamp.enums.Permission;
import com.br.zamp.enums.PermissionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true, exclude = {"users"})
@Entity
@Data
@SQLDelete(sql = "UPDATE user_profile SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class UserProfile extends Base {

  private String name;

  private Integer level;

  @ManyToMany(mappedBy = "userProfiles")
  private Set<User> users = new HashSet<>();

  @ManyToMany(mappedBy = "userProfiles")
  private Set<Company> companies;

  @ElementCollection(targetClass = Permission.class, fetch = FetchType.LAZY)
  @Enumerated(EnumType.STRING)
  private Set<Permission> permissions = new HashSet<>();

  public String getName() {
    return String.format("ROLE_%s", name);
  }

  public String getOriginalName() {
    return name;
  }

  public Set<Permission> getPermissions() {
    var hasAllPermission = permissions.stream().anyMatch(permission -> permission == Permission.ALL);
    return hasAllPermission ? Set.of(Permission.values()) : permissions;
  }

  public Set<Permission> getMenus() {
    return permissions.stream()
      .filter(permission -> permission.getType() == PermissionType.MENU)
      .collect(Collectors.toSet());
  }
}