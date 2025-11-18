package com.khatep.tasktracker.exceptions.exceptions.business;

import jakarta.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(String message) { super(message); }
}