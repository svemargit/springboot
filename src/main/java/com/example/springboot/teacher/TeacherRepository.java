package com.example.springboot.teacher;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
  public Long countById(Integer id);

  List<Teacher> findAllByEnabled(boolean enabled);
}
