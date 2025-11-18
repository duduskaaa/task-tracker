package com.khatep.tasktracker.controllers;

import com.khatep.tasktracker.models.dto.requests.ChangeTaskStatusDto;
import com.khatep.tasktracker.models.dto.requests.TaskRequestDto;
import com.khatep.tasktracker.models.dto.responses.TaskResponseDto;
import com.khatep.tasktracker.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
//TODO: Add standard responses to ResponseEntity
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Void> createTask(@RequestBody TaskRequestDto taskRequestDto) {
        taskService.createTask(taskRequestDto);
        return ResponseEntity
                .ok()
                .build();
    }

    @PatchMapping("{id}/change-status")
    public ResponseEntity<Void> changeTaskStatus(@PathVariable Long id, @RequestBody ChangeTaskStatusDto dto) {
        taskService.updateTaskStatus(id, dto);

        return ResponseEntity
                .ok()
                .build();
    }
}
