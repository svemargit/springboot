package com.example.springboot;

public class UserNotFountException extends Throwable {

  public UserNotFountException(String message) {
    super(message);
  }
}
