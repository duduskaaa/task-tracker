package com.khatep.tasktracker.services.impl;

import com.khatep.tasktracker.exceptions.exceptions.business.TaskNotFound;
import com.khatep.tasktracker.exceptions.exceptions.business.UserNotFoundException;
import com.khatep.tasktracker.mappers.TaskMapper;
import com.khatep.tasktracker.models.dto.requests.ChangeTaskStatusDto;
import com.khatep.tasktracker.models.dto.requests.TaskRequestDto;
import com.khatep.tasktracker.models.dto.responses.TaskResponseDto;
import com.khatep.tasktracker.models.entities.Task;
import com.khatep.tasktracker.models.entities.User;
import com.khatep.tasktracker.models.enums.TaskStatus;
import com.khatep.tasktracker.repositories.TaskRepository;
import com.khatep.tasktracker.repositories.UserRepository;
import com.khatep.tasktracker.services.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
//TODO: Add deleteTask(Long id) + updatePriority(Priority p) +
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    @Override
    public void createTask(TaskRequestDto taskRequestDto) {
        User user = userRepository
                .findById(taskRequestDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + taskRequestDto.getUserId()));

        Task task = taskMapper.toEntity(taskRequestDto);
        task.setUser(user);

        taskRepository.save(task);
    }

    @Override
    public TaskResponseDto findTask(Long id) {
        Task task = taskRepository
                .findById(id)
                .orElseThrow(() -> new TaskNotFound("Task not found with id:" + id));

        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskResponseDto> findTasks(Long userId) {
        List<Task> taskList = taskRepository.findTasksByUserId(userId);

        return taskList.stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public void updateTaskStatus(Long id, ChangeTaskStatusDto dto) {
        Task task = taskRepository
                .findById(id)
                .orElseThrow(() -> new TaskNotFound("Task not found with id: " + id));

        task.setStatus(dto.getStatus());
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository
                .findById(id)
                .orElseThrow(() -> new TaskNotFound("Task not found with id:" + id));

        taskRepository.delete(task);
    }
}
