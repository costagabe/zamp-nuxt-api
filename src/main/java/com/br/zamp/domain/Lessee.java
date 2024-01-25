package com.br.zamp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Lessee extends Base { // Locatário
  private String name;

  @ManyToMany
  private final Set<Building> buildings = new HashSet<>();

  @ManyToMany(mappedBy = "lessees")
  private final Set<Company> companies = new HashSet<>();
}
