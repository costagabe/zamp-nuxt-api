package com.br.zamp.dto;

import com.br.zamp.domain.enums.UserSituation;

public record CreateUserDTO(String name, String email, String password, UserSituation situation) {
}
