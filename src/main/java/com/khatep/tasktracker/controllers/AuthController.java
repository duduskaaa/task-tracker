package com.khatep.tasktracker.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("api/auth/register")
    public void register() {}

    @PostMapping("api/auth/login")
    public void login() {}
}
