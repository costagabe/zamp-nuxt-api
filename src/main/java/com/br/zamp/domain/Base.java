package com.br.zamp.domain;

import com.br.zamp.config.AuditListener;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
@EntityListeners(AuditListener.class)
public class Base implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  public UUID id;

  private UUID createdBy;
  private UUID updatedBy;
  private UUID deletedBy;

  private LocalDateTime createdAt = LocalDateTime.now();
  private LocalDateTime lastUpdatedAt;

  private int version = 1;
  private boolean isDeleted = false;

  public void beforeUpdate() {

  }
  
}