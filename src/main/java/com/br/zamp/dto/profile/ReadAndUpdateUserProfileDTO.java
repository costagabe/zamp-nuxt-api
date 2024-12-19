package com.br.zamp.dto.profile;

import java.util.Set;
import java.util.UUID;

public record ReadAndUpdateUserProfileDTO(
    UUID id, String name, Integer level, Set<String> permissions) {}
