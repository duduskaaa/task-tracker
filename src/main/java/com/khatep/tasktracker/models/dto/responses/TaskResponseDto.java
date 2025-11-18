package com.khatep.tasktracker.models.dto.responses;

import com.khatep.tasktracker.models.enums.TaskPriority;
import com.khatep.tasktracker.models.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDto {
    private String title;
    private TaskPriority priority;
    private TaskStatus status;
}
