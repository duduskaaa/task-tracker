package com.khatep.tasktracker.models.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
}