package com.br.zamp.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateAddressDTO(
    @NotBlank(message = "Rua é obrigatória") String street,
    @NotBlank(message = "Bairro é obrigatório") String neighbourhood,
    @NotBlank(message = "Cidade é obrigatória") String city,
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "CEP Inválido")
        @NotBlank(message = "CEP é obrigatório")
        String cep,
    @NotNull(message = "Número é obrigatório") Integer number,
    String complement) {}
