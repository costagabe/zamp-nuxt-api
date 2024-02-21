package com.br.zamp.dto.entry;

import com.br.zamp.domain.enums.EntryType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.UUID;

public record ReadAndUpdateEntryDTO(
  UUID id,
  String history,
  @NotNull(message = "Campo Obrigatório") EntryType type,
  @NotNull(message = "Campo Obrigatório") @Positive(message = "O valor da transação deve ser positivo.") Float value,
  @NotNull(message = "Campo Obrigatório") UUID classificationAccount,
  @NotNull(message = "Campo Obrigatório") UUID financialAccount,
  @JsonFormat(pattern = "dd/MM/yyyy") LocalDate date
) {
}