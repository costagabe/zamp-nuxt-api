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
public class Lessor extends Base { // Locador (dono do imóvel)
  private String name;

  @ManyToMany(mappedBy = "lessors")
  private final List<Company> companies = new ArrayList<>();
}
