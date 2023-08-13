package com.example.springboot.classroom;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

  public Long countById(Integer id);
}
