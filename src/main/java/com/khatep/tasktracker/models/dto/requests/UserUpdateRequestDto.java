package com.khatep.tasktracker.models.dto.requests;

import java.util.Optional;

public record UserUpdateRequestDto(
        Optional<String> name,
        Optional<String> email,
        Optional<String> password
) {}
