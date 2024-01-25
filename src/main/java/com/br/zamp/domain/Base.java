package com.br.zamp.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Data
public class Base implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  public UUID id;

  @Version
  private int version;

}