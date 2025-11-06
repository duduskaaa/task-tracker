package com.khatep.tasktracker.controllers;

import com.khatep.tasktracker.models.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @GetMapping("/{id}/details")
    public List<Task> getTasks() {
        // plug
        return new ArrayList<>();
    }

    @PostMapping
    public void createTask() {}
}
