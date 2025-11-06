package com.khatep.tasktracker.services.mappers;

import com.khatep.tasktracker.models.User;
import com.khatep.tasktracker.models.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDto userDto) {
        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        return user;
    }
}
