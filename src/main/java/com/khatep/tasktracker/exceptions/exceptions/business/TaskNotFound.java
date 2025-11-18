package com.khatep.tasktracker.exceptions.exceptions.business;

import jakarta.persistence.EntityNotFoundException;

public class TaskNotFound extends EntityNotFoundException {
    public TaskNotFound(String message) {
        super(message);
    }
}
