package com.br.zamp.domain;

import com.br.zamp.domain.enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Rent extends Base {
  @ManyToMany(mappedBy = "rents")
  private final List<Company> companies = new ArrayList<>();
  private LocalDate paymentDay;
  private LocalDate contractInitialDay;
  private LocalDate contractEndDay;
  private LocalDate firstPaymentDay;
  private PaymentType paymentType;
  @ManyToOne
  private Building building;
  private Float value;
  private String assurance; // Garantia
}
