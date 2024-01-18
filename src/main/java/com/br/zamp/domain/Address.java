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
public class Address extends Base {

    @ManyToMany
    private final List<Company> companies = new ArrayList<>();
    private String street;
    private String neighbourhood;
    private String city;
    private String cep;
    private String number;
    private String complement;
}
