package com.br.zamp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Building extends Base {
  private LocalDate capitationDate;

  @ManyToOne
  private Client client;

  @ManyToMany(mappedBy = "buildings")
  private final Set<Client> clients = new HashSet<>();

  @OneToMany
  private final Set<Rent> rents = new HashSet<>();

  @OneToMany
  private final Set<FileStorage> photos = new HashSet<>();

  @ManyToOne
  private Address address;

  @OneToMany(targetEntity = Document.class)
  private Set<Document> documents = new HashSet<>();

  @ManyToMany
  private Set<Company> companies = new HashSet<>();

}
