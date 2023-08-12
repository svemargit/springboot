package com.example.springboot.user;

public class UserNotFoundException extends Throwable {

  public UserNotFoundException(String message) {
    super(message);
  }
}
