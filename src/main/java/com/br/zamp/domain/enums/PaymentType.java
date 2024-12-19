package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
publ@Getter
ic enum PaymentType {
  ADVANCE_PAYMENT("Pagamento antecipado"),
  OVERDUE_PAYMENT("Pagamento vencido");

  private String name;
}
