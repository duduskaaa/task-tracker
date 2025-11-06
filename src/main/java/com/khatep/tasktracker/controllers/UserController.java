package com.khatep.tasktracker.controllers;

import com.khatep.tasktracker.models.User;
import com.khatep.tasktracker.models.dto.UserDto;
import com.khatep.tasktracker.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUsers(@PathVariable Long id) {
        // plug
        return new ResponseEntity<>("id" + id, HttpStatus.OK);
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }
}
