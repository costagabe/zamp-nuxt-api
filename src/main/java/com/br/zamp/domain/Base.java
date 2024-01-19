package com.br.zamp.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@MappedSuperclass
@Data
public class Base implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Version
  private int version;

}