package com.br.zamp.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "parameter_table")
public class Parameter extends Base {

  @Column(name = "parameter_key")
  private String key;

  @Column(name = "parameter_value")
  private String value;

  private String note;

  @ManyToMany(mappedBy = "parameters", cascade = CascadeType.MERGE)
  private Set<Company> companies = new HashSet<>();
}