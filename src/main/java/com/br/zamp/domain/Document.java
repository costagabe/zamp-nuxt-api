package com.br.zamp.domain;

import com.br.zamp.domain.enums.DocumentType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Document extends Base {
    @ManyToMany
    private final List<Company> companies = new ArrayList<>();
    private DocumentType type;
    private String name;
}
