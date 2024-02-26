package com.br.zamp.domain;

import com.br.zamp.domain.enums.ClientType;
import com.br.zamp.domain.enums.PersonType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "clients")
@SQLDelete(sql = "UPDATE clients SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
@Inheritance(strategy = InheritanceType.JOINED)
public class Client extends Base {
  private String name;
  private String email;
  private String phone;
  private String cpf;
  private String cnpj;
  private String rg;

  @Enumerated(EnumType.STRING)
  @ElementCollection(targetClass = ClientType.class, fetch = FetchType.LAZY)
  private Set<ClientType> clientTypes = new HashSet<>();

  @Enumerated(EnumType.STRING)
  private PersonType personType;

  @OneToOne(fetch = FetchType.LAZY)
  private Address address;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
  private Set<Document> documents;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "clients")
  private Set<Company> companies = new HashSet<>();

  @ManyToMany(fetch = FetchType.LAZY)
  private Set<Building> buildings = new HashSet<>();

  @Override
  public void beforeUpdate() {
    address = null;
    documents = null;
    companies = null;
    buildings = null;
  }

}
