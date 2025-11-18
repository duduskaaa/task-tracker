package com.khatep.tasktracker.models.dto.requests;

import com.khatep.tasktracker.models.enums.TaskPriority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDto {
    private Long userId;
    private String title;
    private TaskPriority priority;
}
