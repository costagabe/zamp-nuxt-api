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
public class Address extends Base {


  @ManyToMany(mappedBy = "adresses")
  private final Set<Company> companies = new HashSet<>();
  private String street;
  private String neighbourhood;
  private String city;
  private String cep;
  private String number;
  private String complement;
}
