package com.khatep.tasktracker.models.dto.requests;

import com.khatep.tasktracker.models.enums.TaskPriority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeTaskPriorityDto {
    private TaskPriority priority;
}
