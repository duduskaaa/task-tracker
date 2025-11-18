package com.khatep.tasktracker.exceptions.exceptions.business;

public class EmailIsAlreadyExists extends RuntimeException {
    public EmailIsAlreadyExists(String message) {
        super(message);
    }
}
