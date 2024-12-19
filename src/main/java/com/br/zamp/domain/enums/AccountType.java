package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountType {
  INCOME_ACCOUNT("Conta de receita"),
  EXPENSE_ACCOUNT("Conta de despesa"),
  FINANCIAL_ACCOUNT("Conta financeira"),
  ;
  private final String name;
}
