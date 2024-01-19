package com.br.zamp.domain;

import com.br.zamp.domain.enums.EntryType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Entry extends Base {
  @ManyToMany
  private final List<Company> companies = new ArrayList<>();
  private Float value;
  private EntryType type;
  private LocalDate date;
  private String history;
  @ManyToOne
  private Account financialAccount;
  @ManyToOne
  private Account classificationAccount;
  @ManyToOne
  private Company company;

}
