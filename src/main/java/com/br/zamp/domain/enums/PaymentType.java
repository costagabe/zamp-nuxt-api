package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum PaymentType {
  ADVANCE_PAYMENT("Pagamento antecipado"),
  OVERDUE_PAYMENT("Pagamento vencido");

  private String name;
}
