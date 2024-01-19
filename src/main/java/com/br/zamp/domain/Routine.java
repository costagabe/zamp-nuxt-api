package com.br.zamp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Routine extends Base {
  @ManyToMany(mappedBy = "routines")
  private final List<User> users = new ArrayList<>();
  @ManyToMany(mappedBy = "routines")
  private final List<UserProfile> profiles = new ArrayList<>();
  @ManyToMany(mappedBy = "routines")
  private final List<Company> companies = new ArrayList<>();
  private String description;
  private Integer code;
}