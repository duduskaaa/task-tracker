package com.khatep.tasktracker.exceptions.handlers;

import com.khatep.tasktracker.exceptions.exceptions.EmailIsAlreadyExists;
import com.khatep.tasktracker.exceptions.exceptions.PasswordIsNotStrength;
import com.khatep.tasktracker.exceptions.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    protected ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String error, String message) {
        return ResponseEntity.status(status).body(
                Map.of(
                "timestamp", LocalDateTime.now(),
                "status", status.value(),
                "error", error,
                "message", message
        ));
    }

    @ExceptionHandler(EmailIsAlreadyExists.class)
    public ResponseEntity<Map<String, Object>> handleEmailAlreadyExists(EmailIsAlreadyExists ex) {
        return buildErrorResponse(HttpStatus.CONFLICT, "Email is already exist", ex.getMessage());
    }

    @ExceptionHandler(PasswordIsNotStrength.class)
    public ResponseEntity<Map<String, Object>> handlePasswordIsNotStrength(PasswordIsNotStrength ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Password is strength", ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "User not found", ex.getMessage());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<Map<String, Object>> handleIncorrectPasswordException(IncorrectPasswordException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Incorrect password, try again, bitch", ex.getMessage());
    }

    @ExceptionHandler(EmailIsNotFound.class)
    public ResponseEntity<Map<String, Object>> handleEmailIsNotFoundException(EmailIsNotFound ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Email is not found", ex.getMessage());
    }
}
