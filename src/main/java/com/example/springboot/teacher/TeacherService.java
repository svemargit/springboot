package com.example.springboot.teacher;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

  @Autowired private TeacherRepository teacherRepository;

  public List<Teacher> listAll() {
    return (List<Teacher>) teacherRepository.findAll();
  }

  public void save(Teacher teacher) {
    teacherRepository.save(teacher);
  }

  public Teacher get(Integer id) throws TeacherNotFoundException {
    Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
    if (optionalTeacher.isPresent()) {
      return optionalTeacher.get();
    } else {
      throw new TeacherNotFoundException("Teacher not found!");
    }
  }

  public void delete(Integer id) throws TeacherNotFoundException {
    Long count = teacherRepository.countById(id);
    if (count == null || count == 0) {
      throw new TeacherNotFoundException("Could not find any teachers with ID" + id);
    }
    teacherRepository.deleteById(id);
  }
}
