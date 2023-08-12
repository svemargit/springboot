package com.example.springboot.user;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public List<User> listAll() {
    return (List<User>) userRepository.findAll();
  }

  public void save(User user) {
    userRepository.save(user);
  }

  public User get(Integer id) throws UserNotFoundException {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      throw new UserNotFoundException("User not found!");
    }
  }
}
