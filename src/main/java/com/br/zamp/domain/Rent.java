package com.br.zamp.domain;

import com.br.zamp.domain.enums.PaymentType;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "rent_table")
@SQLDelete(sql = "UPDATE rent_table SET is_deleted = true WHERE id=?")
@SQLRestriction("is_deleted is false")
public class Rent extends Base {

  @ManyToMany(mappedBy = "rents")
  private final Set<Company> companies = new HashSet<>();

  private LocalDate paymentDay;
  private LocalDate contractInitialDay;
  private LocalDate contractEndDay;
  private LocalDate firstPaymentDay;

  @Enumerated(EnumType.STRING)
  private PaymentType paymentType;

  private String assurance; // Garantia
  @ManyToOne private Building building;

  @Column(name = "rent_value")
  private Float value;
}
