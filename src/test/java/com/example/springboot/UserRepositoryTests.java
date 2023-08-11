package com.example.springboot;

import com.example.springboot.user.User;
import com.example.springboot.user.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
  @Autowired private UserRepository userRepository;

  @Test
  public void testAddNew() {
    User user = new User();
    user.setEmail("asd@icloud.com");
    user.setPassword("asdasd");
    user.setFirstName("jmeno2");
    user.setLastName("P5ijmiasn");

    User savedUser = userRepository.save(user);

    Assert.notNull(savedUser, "user is empty");
    Assert.isTrue(savedUser.getId() > 0);
  }

  @Test
  public void testListAll() {
    Iterable<User> users = userRepository.findAll();
    for (User user : users) {
      System.out.println(user.toString());
    }
  }

  @Test
  public void testUpdate() {
    Integer userId = 2;
    Optional<User> optionalUser = userRepository.findById(userId);
    User user = optionalUser.get();
    String newPassword = "newPassword";
    user.setPassword(newPassword);
    userRepository.save(user);
    User updatedUser = userRepository.findById(userId).get();
    Assert.isTrue(updatedUser.getPassword().equals(newPassword));
  }

  @Test
  public void testGet() {
    Integer userId = 2;
    Optional<User> optionalUser = userRepository.findById(userId);
    Assert.notNull(optionalUser);
  }

  @Test
  public void testDelete() {
    Integer userId = 7;
    userRepository.deleteById(userId);
    Optional<User> optionalUser = userRepository.findById(userId);
    Assert.isTrue(optionalUser.isEmpty());
  }
}
