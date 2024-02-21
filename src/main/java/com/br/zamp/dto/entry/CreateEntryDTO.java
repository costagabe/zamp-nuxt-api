package com.br.zamp.dto.entry;

import com.br.zamp.domain.enums.EntryType;

import java.util.UUID;

public record CreateEntryDTO(
        String name,
        String code,
        String history,
        EntryType type,
        Float value,
        UUID otherAccountId
) {
}
