package com.example.springboot.classroom;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
  @Autowired private ClassroomRepository classroomRepository;

  public List<Classroom> getAllClassroomData() {
    return classroomRepository.findAll();
  }
}
