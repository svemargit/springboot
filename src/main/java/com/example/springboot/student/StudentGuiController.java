package com.example.springboot.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentGuiController {

  @Autowired private StudentService studentService;

  @Autowired
  public StudentGuiController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/students")
  public String showStudentList(Model model) {
    List<Student> students = studentService.getStudents();
    model.addAttribute("listStudents", students);
    return "students";
  }
}
