package com.example.springboot.student;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

  private final StudentService;
  @GetMapping
  public List<Student> getStudents() {
    return new List<Student>() {
      //todo
    }
  }
}
