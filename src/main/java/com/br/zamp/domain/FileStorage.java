package com.br.zamp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class FileStorage extends Base {
    @ManyToMany(mappedBy = "fileStorages")
    private final List<Company> companies = new ArrayList<>();

    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false, length = 10)
    private String extension;

    private String contentType;

    private Long size;

}