package com.khatep.tasktracker.exceptions.handlers;

import com.khatep.tasktracker.controllers.GlobalExceptionHandler;
import com.khatep.tasktracker.exceptions.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public class PasswordIsNotStrength extends GlobalExceptionHandler {
    @ExceptionHandler(PasswordIsNotStrength.class)
    public ResponseEntity<Map<String, Object>> handlePasswordIsNotStrength(PasswordIsNotStrength ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Password is strength", ex.getMessage());
    }
}
