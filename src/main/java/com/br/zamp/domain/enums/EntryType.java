package com.br.zamp.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EntryType {
    ENTRADA("Entrada"),
    SAIDA("Saída");
    private final String name;
}
