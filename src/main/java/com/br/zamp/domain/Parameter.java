package com.br.zamp.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Parameter extends Base {

    private String key;


    private String value;

    private String note;

    @ManyToMany(mappedBy = "parameters", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)

    private Set<Company> companies = new HashSet<>();

    public void removeCompanies() {
        this.companies.forEach(company -> company.getParameters().remove(this));
        this.companies = new HashSet<>();
    }


}