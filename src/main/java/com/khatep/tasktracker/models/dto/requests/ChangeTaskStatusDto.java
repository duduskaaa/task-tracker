package com.khatep.tasktracker.models.dto.requests;

import com.khatep.tasktracker.models.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeTaskStatusDto {
    TaskStatus status;
}
