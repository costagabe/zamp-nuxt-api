package com.br.zamp.dto.profile;

import java.util.Set;

public record CreateUserProfileDTO(String name, Integer level, Set<String> permissions) {}
