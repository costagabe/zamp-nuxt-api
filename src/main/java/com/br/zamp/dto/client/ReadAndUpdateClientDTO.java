package com.br.zamp.dto.client;

import com.br.zamp.dto.address.CreateAddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;
import java.util.UUID;

public record ReadAndUpdateClientDTO(
  UUID id,
  @NotBlank(message = "Nome Completo é obrigatório") String name,
  @Email(message = "Email inválido") @NotBlank(message = "Email é obrigatório") String email,
  @NotBlank(message = "Telefone é obrigatório") String phone,
  @Pattern(regexp = "PF|PJ", message = "Tipo é obrigatório") String personType,
  @Size(min = 1, message = "Tipo de cliente é obrigatório") List<@Pattern(regexp = "LESSEE|LESSOR") String> clientTypes,
  String cpf,
  String cnpj,
  @NotBlank(message = "RG é obrigatório") String rg,
  @Valid CreateAddressDTO address
) {
  @SuppressWarnings("unused")
  @AssertTrue(message = "CPF ou CNPJ é obrigatório")
  boolean isDocumentOk() {
    return cpf() != null || cnpj() != null;
  }
}