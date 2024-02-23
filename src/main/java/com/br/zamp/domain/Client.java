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
  private Set<ClientType> types;

  @Enumerated(EnumType.STRING)
  private PersonType personType;


  @OneToOne
  private Address address;

  @OneToMany
  private Set<Document> documents;

  @ManyToMany(mappedBy = "clients")
  private final Set<Company> companies = new HashSet<>();

  @ManyToMany
  private final Set<Building> buildings = new HashSet<>();

}
