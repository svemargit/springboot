package com.example.springboot;

import com.example.springboot.student.StudentService;
import com.example.springboot.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @Autowired private StudentService studentService;
  @Autowired private TeacherService teacherService;

  @GetMapping("")
  public String showHomePage() {
    return "index";
  }

  @GetMapping("/everyone")
  public String showEveryoneList(Model model) {
    model.addAttribute("listStudents", studentService.getStudents());
    model.addAttribute("listTeachers", teacherService.getTeachers());
    model.addAttribute("listEnabledStudents", studentService.findAllEnabled());
    model.addAttribute("listEnabledTeachers", teacherService.findAllByEnabled());
    return "everyone";
  }
}
