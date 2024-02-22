package com.br.zamp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SQLDelete(sql = "UPDATE lessor SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class Lessor extends Base { // Locador (dono do imóvel)
  @ManyToMany(mappedBy = "lessors")
  private final List<Company> companies = new ArrayList<>();
  private String name;
}
