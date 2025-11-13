package com.khatep.tasktracker.exceptions;

public class EmailIsAlreadyExists extends RuntimeException {
    public EmailIsAlreadyExists(String message) {
        super(message);
    }
}
