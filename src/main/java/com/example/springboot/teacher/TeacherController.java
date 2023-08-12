package com.example.springboot.teacher;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TeacherController {
  @Autowired private TeacherService teacherService;

  @GetMapping("/teachers")
  public String showTeacherList(Model model) {
    List<Teacher> listTeachers = teacherService.listAll();
    model.addAttribute("listTeachers", listTeachers);
    return "teachers";
  }

  @GetMapping("/teachers/new")
  public String showNewForm(Model model) {
    model.addAttribute("teacher", new Teacher());
    model.addAttribute("pageTitle", "Add new teacher");
    return "teacher_form";
  }

  @PostMapping("/teachers/save")
  public String saveTeacher(Teacher teacher, RedirectAttributes redirectAttributes) {
    teacherService.save(teacher);
    redirectAttributes.addFlashAttribute("message", "The teacher has been saved sucesfully");
    return "redirect:/teachers";
  }

  @GetMapping("/teachers/edit/{id}")
  public String showEditForm(
      @PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
    try {
      Teacher teacher = teacherService.get(id);
      model.addAttribute("teacher", teacher);
      model.addAttribute("pageTitle", "Edit teacher by id " + id);
      return "teacher_form";
    } catch (TeacherNotFoundException e) {
      redirectAttributes.addFlashAttribute("message", "The teacher has been saved sucesfully");
      return "redirect:/teachers";
    }
  }

  @GetMapping("/teachers/delete/{id}")
  public String deleteTeacher(
      @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
    try {
      teacherService.delete(id);
      redirectAttributes.addFlashAttribute("alert", "The teacher has been deleted sucesfully");
    } catch (TeacherNotFoundException e) {
      redirectAttributes.addFlashAttribute("alert", e.getMessage());
    }
    return "redirect:/teachers";
  }
}
