package com.khatep.tasktracker.exceptions;

public class EmailIsAlreadyExist extends RuntimeException {
  public EmailIsAlreadyExist(String message) {
    super(message);
  }
}
