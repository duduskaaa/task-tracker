package com.khatep.tasktracker.controllers;

import com.khatep.tasktracker.models.dto.responses.UserResponseDto;
import com.khatep.tasktracker.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findUser(id);
        return ResponseEntity
                .ok(userResponseDto);
    }
}
