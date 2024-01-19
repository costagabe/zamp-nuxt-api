package com.br.zamp.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Building extends Base {
  @ManyToMany
  @JoinTable(name = "building_lessee", joinColumns = @JoinColumn(name = "building_id"), inverseJoinColumns = @JoinColumn(name = "lessee_id"))
  private final List<Lessee> lessees = new ArrayList<>();
  @OneToMany(mappedBy = "building")
  private final List<Rent> rents = new ArrayList<>();
  @OneToMany(targetEntity = FileStorage.class)
  private final List<FileStorage> photos = new ArrayList<>();
  private LocalDate capitationDate;
  @ManyToOne
  private Address address;
  @OneToMany(targetEntity = Document.class)
  private List<Document> documents;

  @ManyToMany
  private List<Company> companies;

}
