package com.khatep.tasktracker.services;

import com.khatep.tasktracker.models.dto.requests.TaskRequestDto;
import com.khatep.tasktracker.models.dto.responses.TaskResponseDto;
import com.khatep.tasktracker.models.enums.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    void createTask(TaskRequestDto taskRequestDto);

    TaskResponseDto findTask(Long id);

    List<TaskResponseDto> findTasks(Long userId);

    void updateTaskStatus(Long id, TaskStatus taskStatus);
}
