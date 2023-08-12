package com.example.springboot.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public void addNewStudent(Student student) {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      throw new IllegalStateException("Email taken");
    }
    studentRepository.save(student);
  }

  public void deleteStudent(Integer studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if (!exists) {
      throw new IllegalStateException(String.format("student with id %d not found.", studentId));
    }
    studentRepository.deleteById(studentId);
  }

  @Transactional
  public void updateStudent(Integer studentId, String firstName, String lastName, String email) {
    Student student =
        studentRepository
            .findById(studentId)
            .orElseThrow(
                () ->
                    new IllegalStateException(
                        String.format("Student with id %d not found.", studentId)));
    if (firstName != null
        && !firstName.isEmpty()
        && !Objects.equals(student.getFirstName(), firstName)) {
      student.setFirstName(firstName);
    }
    if (lastName != null
        && !lastName.isEmpty()
        && !Objects.equals(student.getLastName(), lastName)) {
      student.setLastName(lastName);
    }
    if (email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)) {
      Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
      if (studentOptional.isPresent()) {
        throw new IllegalStateException("Email taken");
      }
      student.setEmail(email);
    }
  }
}
