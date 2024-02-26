package com.br.zamp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SQLDelete(sql = "UPDATE file_storage SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class FileStorage extends Base {
  private String contentType;
  private Long size;

  @Column(unique = true, nullable = false)
  private String publicPath;

  @Column(nullable = false)
  private String filename;

  @Column(nullable = false, length = 10)
  private String extension;
}