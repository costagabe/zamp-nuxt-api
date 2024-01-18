package com.br.zamp.domain;

import com.br.zamp.domain.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Account extends Base {
    private String name;
    private String code;
    private AccountType type;
    private Float balance;

    @ManyToMany(mappedBy = "accounts")
    private Set<Company> companies;

}
