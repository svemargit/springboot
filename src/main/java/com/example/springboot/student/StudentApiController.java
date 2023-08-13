package com.example.springboot.student;

import com.example.springboot.UserNotFountException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentApiController {

  private final StudentService studentService;

  @Autowired
  public StudentApiController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @PostMapping
  public void registerNewStudent(@RequestBody Student student) throws UserNotFountException {
    studentService.addNewStudent(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Integer studentId)
      throws UserNotFountException {
    studentService.deleteStudent(studentId);
  }

  @PutMapping(path = {"{studentId}"})
  public void updateStudent(
      @PathVariable("studentId") Integer studentId,
      @RequestParam(required = false) String firstName,
      @RequestParam(required = false) String lastName,
      @RequestParam(required = false) String email)
      throws UserNotFountException {
    studentService.updateStudent(studentId, firstName, lastName, email);
  }
}
