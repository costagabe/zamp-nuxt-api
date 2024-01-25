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
public class Contract extends Base {
  @ManyToMany(mappedBy = "contracts")
  private final Set<Company> companies = new HashSet<>();
  private String test;

}
