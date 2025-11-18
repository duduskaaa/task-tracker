package com.khatep.tasktracker.services;

import com.khatep.tasktracker.models.dto.requests.UserRequestDto;
import com.khatep.tasktracker.models.dto.responses.UserResponseDto;

public interface UserService {
    void createUser(UserRequestDto userRequestDto);

    UserResponseDto findUser(Long id);

    UserResponseDto login(UserRequestDto userRequestDto);
}
