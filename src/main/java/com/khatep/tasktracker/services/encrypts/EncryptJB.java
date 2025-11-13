package com.khatep.tasktracker.services;

import com.khatep.tasktracker.interfaces.EncryptService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptJB implements EncryptService {
    private static final int WORKLOAD = 10;

    @Override
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(WORKLOAD));
    }

    @Override
    public boolean check(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }
}
