package com.khatep.tasktracker.services;

import com.khatep.tasktracker.interfaces.EncryptService;
import org.springframework.stereotype.Service;

@Service
public class EncryptB implements EncryptService {
    @Override
    public String encrypt(String password) {
        return "Plug";
    }
}
