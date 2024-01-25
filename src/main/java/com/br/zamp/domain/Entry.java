package com.br.zamp.domain;

import com.br.zamp.domain.enums.EntryType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entries")
@Data
public class Entry extends Base {

  @Column(name = "entry_value")
  private Float value;
  private EntryType type;
  private LocalDate date;
  private String history;

  @ManyToMany(mappedBy = "entries")
  private final Set<Company> companies = new HashSet<>();

  @ManyToOne
  private Account financialAccount;

  @ManyToOne
  private Account classificationAccount;

  @ManyToOne
  private Company company;

}
