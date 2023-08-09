package com.example.springboot.student;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

public class StudentService {
  @GetMapping
  public List<Student> getStudents() {
    return List.of(
        new Student(1L, "Mariam", 24, LocalDate.of(1999, 2, 1), "mariam.jamal@icloud.com"));
  }
}
