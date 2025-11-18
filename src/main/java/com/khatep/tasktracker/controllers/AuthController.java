package com.khatep.tasktracker.controllers;

import com.khatep.tasktracker.models.dto.requests.UserRequestDto;
import com.khatep.tasktracker.models.dto.responses.UserResponseDto;
import com.khatep.tasktracker.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

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
