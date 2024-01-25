package com.br.zamp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class FileStorage extends Base {
  private String contentType;
  private Long size;

  @Column(unique = true, nullable = false)
  private String uuid;

  @Column(nullable = false)
  private String filename;

  @Column(nullable = false, length = 10)
  private String extension;

  @ManyToMany(mappedBy = "fileStorages")
  private final Set<Company> companies = new HashSet<>();
}