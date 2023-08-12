package com.example.springboot.teacher;

import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
  public Long countById(Integer id);
}
