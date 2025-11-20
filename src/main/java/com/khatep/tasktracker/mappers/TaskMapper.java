package com.khatep.tasktracker.mappers;

import com.khatep.tasktracker.models.dto.requests.TaskRequestDto;
import com.khatep.tasktracker.models.dto.responses.TaskResponseDto;
import com.khatep.tasktracker.models.entities.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
//TODO: Использовать Jackson для маппинга ENUM значений
public class TaskMapper {
    public Task toEntity(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setTitle(taskRequestDto.getTitle());
        task.setPriority(taskRequestDto.getPriority());

        return task;
    }

    public TaskResponseDto toDto(Task task) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTitle(task.getTitle());
        taskResponseDto.setPriority(task.getPriority());
        taskResponseDto.setStatus(task.getStatus());

        return taskResponseDto;
    }
}
