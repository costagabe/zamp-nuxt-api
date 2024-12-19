package com.br.zamp.dto.account;

import com.br.zamp.domain.enums.AccountType;
import java.util.UUID;

public record ReadAndUpdateAccountDTO(
    UUID id, String name, String code, AccountType type, Float balance) {}
