package com.khatep.tasktracker.services;

import com.khatep.tasktracker.models.User;
import com.khatep.tasktracker.models.dto.UserDto;
import com.khatep.tasktracker.repositories.UserRepository;
import com.khatep.tasktracker.services.mappers.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPasswordHash("Hash-plug");
        userRepository.save(user);
    }
}
