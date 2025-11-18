package com.khatep.tasktracker.services.encrypts.impl;

import com.khatep.tasktracker.exceptions.exceptions.business.PasswordIsNotStrength;
import com.khatep.tasktracker.services.encrypts.EncryptService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptServiceJBImpl implements EncryptService {
    private static final int WORKLOAD = 10;

    public boolean checkPasswordStrength(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*()-].*");
    }

    @Override
    public String encrypt(String password) {
        if (!checkPasswordStrength(password)) {
            throw new PasswordIsNotStrength("Password is not strength. Try to add more special symbols, digits or characters");
        }

        return BCrypt.hashpw(password, BCrypt.gensalt(WORKLOAD));
    }

    @Override
    public boolean check(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }
}
