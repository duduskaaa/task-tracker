package com.khatep.tasktracker.mappers;

import com.khatep.tasktracker.models.entities.User;
import com.khatep.tasktracker.models.dto.requests.UserRequestDto;
import com.khatep.tasktracker.models.dto.responses.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequestDto userRequestDto) {
        User user = new User();

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());

        return user;
    }

    public UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());

        return userResponseDto;
    }
}
