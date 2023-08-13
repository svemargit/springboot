package com.example.springboot.teacher;

import com.example.springboot.UserNotFountException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

  @Autowired private TeacherRepository teacherRepository;

  public List<Teacher> getTeachers() {
    return (List<Teacher>) teacherRepository.findAll();
  }

  public List<Teacher> findAllByEnabled() {
    return teacherRepository.findAllByEnabled(true);
  }

  public void save(Teacher teacher) {
    teacherRepository.save(teacher);
  }

  public Teacher get(Integer id) throws UserNotFountException {
    Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
    if (optionalTeacher.isPresent()) {
      return optionalTeacher.get();
    } else {
      throw new UserNotFountException("Teacher not found!");
    }
  }

  public void delete(Integer id) throws UserNotFountException {
    Long count = teacherRepository.countById(id);
    if (count == null || count == 0) {
      throw new UserNotFountException("Could not find any teacher with ID" + id);
    }
    teacherRepository.deleteById(id);
  }
}
