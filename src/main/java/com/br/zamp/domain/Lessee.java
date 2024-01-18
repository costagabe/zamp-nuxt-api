package com.br.zamp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Lessee extends Base { // Locatário
    @ManyToMany(mappedBy = "lessees")
    private final List<Company> companies = new ArrayList<>();
    private String name;
}
