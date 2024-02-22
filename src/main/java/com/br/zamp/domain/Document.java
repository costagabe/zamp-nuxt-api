package com.br.zamp.domain;

import com.br.zamp.domain.enums.DocumentType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SQLDelete(sql = "UPDATE document SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class Document extends Base {
  private String name;

  @ManyToOne
  private Client client;

  @ManyToMany(mappedBy = "documents")
  private final List<Company> companies = new ArrayList<>();

  @Enumerated(EnumType.STRING)
  private DocumentType type;
}
