package com.example.springboot.classroom;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassroomController {
  @Autowired private ClassroomService classroomService;

  @GetMapping("/classrooms")
  public String showClassroomsList(Model model) {
    List<Classroom> listClassrooms = classroomService.getAllClassroomData();
    model.addAttribute("listClassrooms", listClassrooms);
    return "classroom";
  }
}
