package com.br.zamp.dto.user;

import java.util.UUID;

public record CreateUserDTO(String name, String email, UUID profileId) {
}
