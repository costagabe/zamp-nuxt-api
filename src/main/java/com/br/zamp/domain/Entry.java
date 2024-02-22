package com.br.zamp.domain;

import com.br.zamp.domain.enums.EntryType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entries")
@Data
@SQLDelete(sql = "UPDATE entries SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class Entry extends Base {

  @ManyToMany(mappedBy = "entries")
  private final Set<Company> companies = new HashSet<>();
  @Column(name = "entry_value")
  private Float value;
  @Enumerated(EnumType.STRING)
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
