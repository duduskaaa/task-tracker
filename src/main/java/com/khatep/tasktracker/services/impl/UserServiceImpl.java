package com.khatep.tasktracker.services.impl;

import com.khatep.tasktracker.exceptions.exceptions.business.EmailIsAlreadyExists;
import com.khatep.tasktracker.exceptions.exceptions.business.EmailIsNotFound;
import com.khatep.tasktracker.exceptions.exceptions.business.IncorrectPasswordException;
import com.khatep.tasktracker.exceptions.exceptions.business.UserNotFoundException;
import com.khatep.tasktracker.mappers.UserMapper;
import com.khatep.tasktracker.models.dto.requests.UserRequestDto;
import com.khatep.tasktracker.models.dto.responses.UserResponseDto;
import com.khatep.tasktracker.models.entities.User;
import com.khatep.tasktracker.repositories.UserRepository;
import com.khatep.tasktracker.services.encrypts.EncryptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final EncryptService encryptService;

    public void createUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new EmailIsAlreadyExists("User email is already used: " + userRequestDto.getEmail());
        }

        User user = userMapper.toEntity(userRequestDto);
        user.setPasswordHash(encryptService.encrypt(userRequestDto.getPassword()));
        userRepository.save(user);


    }

    public UserResponseDto findUser(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        return userMapper.toDto(user);
    }

    public UserResponseDto login(UserRequestDto userRequestDto) {
        User user = userRepository
                .findUserByEmail(userRequestDto.getEmail())
                .orElseThrow(() -> new EmailIsNotFound("Email not found with: " + "<"+userRequestDto.getEmail()+">"));


        if (encryptService.check(
                userRequestDto.getPassword(),
                user.getPasswordHash()
        )) {
            return userMapper.toDto(user);
        }

        throw new IncorrectPasswordException("Incorrect password");
    }
}
