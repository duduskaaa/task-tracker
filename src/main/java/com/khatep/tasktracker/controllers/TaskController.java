package com.khatep.tasktracker.controllers;

import com.khatep.tasktracker.models.dto.requests.TaskRequestDto;
import com.khatep.tasktracker.models.dto.responses.TaskResponseDto;
import com.khatep.tasktracker.models.enums.TaskStatus;
import com.khatep.tasktracker.services.impl.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskServiceImpl taskService;

    @GetMapping("/{userId}")
    public List<TaskResponseDto> getTasks(@PathVariable Long userId) {
        return taskService.findTasks(userId);
    }

    @PostMapping("/create")
    public void createTask(@RequestBody TaskRequestDto taskRequestDto) {
        taskService.createTask(taskRequestDto);
    }

    @PatchMapping("{id}/change-status")
    public void changeTaskStatus(@PathVariable Long id, TaskStatus taskStatus) {
        taskService.updateTaskStatus(id, taskStatus);
    }
}
