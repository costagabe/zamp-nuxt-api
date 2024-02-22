package com.br.zamp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SQLDelete(sql = "UPDATE lessee SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class Lessee extends Base { // Locatário
  @ManyToMany
  private final Set<Building> buildings = new HashSet<>();
  @ManyToMany(mappedBy = "lessees")
  private final Set<Company> companies = new HashSet<>();
  private String name;
}
