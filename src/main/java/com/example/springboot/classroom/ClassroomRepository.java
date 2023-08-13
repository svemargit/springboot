package com.example.springboot.classroom;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
  @Query(
      value = "SELECT * FROM v_classroom vc LEFT JOIN teachers t ON vc.teacher_id = t.id;",
      nativeQuery = true)
  List<Classroom> findAll();
}
