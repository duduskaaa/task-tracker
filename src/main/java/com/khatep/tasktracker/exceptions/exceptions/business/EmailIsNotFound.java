package com.khatep.tasktracker.exceptions.exceptions.business;

import jakarta.persistence.EntityNotFoundException;

public class EmailIsNotFound extends EntityNotFoundException {
    public EmailIsNotFound(String message) {
        super(message);
    }
}
