package com.example.springboot.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
  @Autowired private UserService userService;

  @GetMapping("/users")
  public String showUserList(Model model) {
    List<User> listUsers = userService.listAll();
    model.addAttribute("listUsers", listUsers);
    return "users";
  }

  @GetMapping("/users/new")
  public String showNewForm(Model model) {
    model.addAttribute("user", new User());
    return "user_form";
  }

  @PostMapping("/users/save")
  public String saveUser(User user, RedirectAttributes redirectAttributes) {
    userService.save(user);
    redirectAttributes.addFlashAttribute("message", "The user has been saved sucesfully");
    return "redirect:/users";
  }
}
