package com.khatep.tasktracker.services.encrypts;

public interface EncryptService {
    String encrypt(String line);

    boolean check(String line, String hash);
}
