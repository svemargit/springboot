package com.example.springboot;

import com.example.springboot.student.Student;
import com.example.springboot.student.StudentService;
import com.example.springboot.user.User;
import com.example.springboot.user.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @Autowired private StudentService studentService;
  @Autowired private UserService userService;

  @GetMapping("")
  public String showHomePage() {
    return "index";
  }

  @GetMapping("/everyone")
  public String showEveryoneList(Model model) {
    List<Student> students = studentService.getStudents();
    List<User> users = userService.listAll();
    model.addAttribute("listStudents", students);
    model.addAttribute("listUsers", users);
    return "everyone";
  }
}
