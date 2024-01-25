package com.br.zamp.domain;

import com.br.zamp.domain.enums.EntryType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
  @ManyToMany
  @JoinTable(
      name = "entry_company",
      joinColumns = @JoinColumn(name = "entry_id"),
      inverseJoinColumns = @JoinColumn(name = "company_id")
  )
  private final List<Company> companies = new ArrayList<>();

  @ManyToOne
  @JoinTable(
      name = "entry_financial_account",
      joinColumns = @JoinColumn(name = "entry_id"),
      inverseJoinColumns = @JoinColumn(name = "account_id")
  )
  private Account financialAccount;

  @ManyToOne
  @JoinTable(
      name = "entry_classification_account",
      joinColumns = @JoinColumn(name = "entry_id"),
      inverseJoinColumns = @JoinColumn(name = "account_id")
  )
  private Account classificationAccount;

  @ManyToOne
  @JoinTable(
      name = "entry_company_one",
      joinColumns = @JoinColumn(name = "entry_id"),
      inverseJoinColumns = @JoinColumn(name = "company_id")
  )
  private Company company;

}
