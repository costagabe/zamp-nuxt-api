package com.br.zamp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SQLDelete(sql = "UPDATE company SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class Company extends Base {

  private String name;

  private String cnpj;

  @ManyToMany
  private Set<User> users = new HashSet<>();

  @ManyToMany
  private Set<Account> accounts;

  @ManyToMany
  private Set<Address> adresses;

  @ManyToMany
  private Set<Building> buildings;

  @ManyToMany
  private Set<Contract> contracts;

  @ManyToMany
  private Set<Document> documents;

  @ManyToMany
  private Set<Entry> entries;

  @ManyToMany
  private Set<FileStorage> fileStorages;

  @ManyToMany
  private Set<Client> clients;

  @ManyToMany
  private Set<Parameter> parameters = new HashSet<>();

  @ManyToMany
  private Set<Rent> rents;

  @ManyToMany
  private Set<UserProfile> userProfiles;

}