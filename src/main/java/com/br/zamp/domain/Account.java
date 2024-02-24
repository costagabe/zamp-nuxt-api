package com.br.zamp.domain;

import com.br.zamp.domain.enums.AccountType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SQLDelete(sql = "UPDATE account SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class Account extends Base {
  private String name;
  private String code;
  @Enumerated(EnumType.STRING)
  private AccountType type;
  private Float balance;

  @ManyToMany(mappedBy = "accounts")
  private Set<Company> companies;

  @OneToMany(mappedBy = "financialAccount")
  private Set<Entry> entries;

}
