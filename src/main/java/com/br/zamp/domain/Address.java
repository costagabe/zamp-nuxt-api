package com.br.zamp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SQLDelete(sql = "UPDATE address SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class Address extends Base {

  @ManyToMany(mappedBy = "adresses")
  private final Set<Company> companies = new HashSet<>();

  private String street;
  private String neighbourhood;
  private String city;
  private String cep;
  private String number;
  private String complement;
}
