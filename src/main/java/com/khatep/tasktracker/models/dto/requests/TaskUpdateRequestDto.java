package com.khatep.tasktracker.models.dto.requests;

import com.khatep.tasktracker.models.enums.TaskPriority;
import com.khatep.tasktracker.models.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public record TaskUpdateRequestDto(
        Optional<String> title,
        Optional<TaskPriority> priority,
        Optional<TaskStatus> status
) {}
