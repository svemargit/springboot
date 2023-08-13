package com.example.springboot.student;

import com.example.springboot.UserNotFountException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

  @GetMapping("/students/changeStatus/{id}/{enabled}")
  public String changeStudentStatus(
      @PathVariable("id") Integer id,
      @PathVariable("enabled") boolean enabled,
      RedirectAttributes redirectAttributes) {
    try {
      Student student = studentService.get(id);
      student.setEnabled(enabled);
      studentService.save(student);
      String message =
          enabled
              ? "The student has been hired successfully"
              : "The student has been fired successfully";
      String warning = enabled ? "message" : "alert";
      redirectAttributes.addFlashAttribute(warning, message);
    } catch (UserNotFountException e) {
      redirectAttributes.addFlashAttribute("alert", e.getMessage());
    }
    return "redirect:/students";
  }

  @GetMapping("/students/new")
  public String showNewForm(Model model) {
    model.addAttribute("student", new Student());
    model.addAttribute("pageTitle", "Add new Student");
    return "student_form";
  }

  @GetMapping("/students/edit/{id}")
  public String showEditForm(
      @PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Student student = studentService.get(id);
      model.addAttribute("student", student);
      model.addAttribute("pageTitle", "Edit student by id " + id);
      return "student_form";
    } catch (UserNotFountException e) {
      redirectAttributes.addFlashAttribute("message", "The student has been saved sucesfully");
      return "redirect:/students";
    }
  }

  @GetMapping("/students/delete/{id}")
  public String deleteStudent(
      @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
    try {
      studentService.deleteStudent(id);
      redirectAttributes.addFlashAttribute("alert", "The student has been deleted sucesfully");
    } catch (UserNotFountException e) {
      redirectAttributes.addFlashAttribute("alert", e.getMessage());
    }
    return "redirect:/students";
  }

  @PostMapping("/students/save")
  public String saveStudent(
      Student student,
      @RequestParam("dateOfBirth") String submittedDate,
      RedirectAttributes redirectAttributes)
      throws UserNotFountException {
    Integer id = student.getId();
    String email;
    if (id != null) {
      Student studentData = studentService.get(id);
      email = studentData.getEmail();
      student.setEnabled(studentData.getEnabled());
    } else {
      student.setEnabled(true);
      email = generateEmail(student);
    }
    student.setDob(getDob(submittedDate));
    student.setEmail(email);
    studentService.save(student);
    redirectAttributes.addFlashAttribute("message", "The Student has been saved successfully");
    return "redirect:/students";
  }

  private String generateEmail(Student student) {
    String lastName =
        student.getLastName().length() > 3
            ? student.getLastName().substring(0, 3)
            : student.getLastName();
    String firstName = student.getFirstName().substring(0, 1);
    String username = lastName + firstName;
    return String.format("%s@myschool.edu", username.toLowerCase());
  }

  private static LocalDate getDob(String submittedDate) {
    Pattern pattern = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)");
    Matcher matcher = pattern.matcher(submittedDate);
    LocalDate dob;
    if (matcher.matches()) {
      int day = Integer.parseInt(matcher.group(1));
      int month = Integer.parseInt(matcher.group(2));
      int year = Integer.parseInt(matcher.group(3));
      dob = LocalDate.of(year, month, day);
    } else {
      dob = LocalDate.of(2023, 1, 1);
    }
    return dob;
  }
}
