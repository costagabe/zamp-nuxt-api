package com.br.zamp.dto;

import com.br.zamp.domain.enums.UserSituation;

import java.util.UUID;

public record ReadAndUpdateUserDTO(UUID id,  String name, String email, UserSituation situation) {
}
