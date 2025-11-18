package com.khatep.tasktracker.exceptions.exceptions.business;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
