package com.khatep.tasktracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String error, String message) {
        return ResponseEntity.status(status).body(
                Map.of(
                "timestamp", LocalDateTime.now(),
                "status", status.value(),
                "error", error,
                "message", message
        ));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "User not found", ex.getMessage());
    }
}
