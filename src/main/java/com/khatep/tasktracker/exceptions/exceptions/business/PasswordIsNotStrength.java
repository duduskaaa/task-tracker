package com.khatep.tasktracker.exceptions.exceptions.business;

public class PasswordIsNotStrength extends RuntimeException {
    public PasswordIsNotStrength(String message) {
        super(message);
    }
}
