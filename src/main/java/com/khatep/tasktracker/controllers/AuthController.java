package com.khatep.tasktracker.controllers;

import com.khatep.tasktracker.models.dto.requests.UserRequestDto;
import com.khatep.tasktracker.models.dto.responses.UserResponseDto;
import com.khatep.tasktracker.services.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRequestDto userRequestDto) {
        userService.createUser(userRequestDto);

        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.login(userRequestDto);

        return ResponseEntity
                .accepted()
                .body(userResponseDto);
    }
}
