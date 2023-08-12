package com.example.springboot;

import com.example.springboot.teacher.Teacher;
import com.example.springboot.teacher.TeacherRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TeacherRepositoryTests {
  @Autowired private TeacherRepository teacherRepository;

  @Test
  public void testAddNew() {
    Teacher teacher = new Teacher();
    teacher.setEmail("asd@icloud.com");
    teacher.setPassword("asdasd");
    teacher.setFirstName("jmeno2");
    teacher.setLastName("P5ijmiasn");

    Teacher savedTeacher = teacherRepository.save(teacher);

    Assert.notNull(savedTeacher, "teacher is empty");
    Assert.isTrue(savedTeacher.getId() > 0);
  }

  @Test
  public void testListAll() {
    Iterable<Teacher> teachers = teacherRepository.findAll();
    for (Teacher teacher : teachers) {
      System.out.println(teacher.toString());
    }
  }

  @Test
  public void testUpdate() {
    Integer teacherId = 2;
    Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
    Teacher teacher = optionalTeacher.get();
    String newPassword = "newPassword";
    teacher.setPassword(newPassword);
    teacherRepository.save(teacher);
    Teacher updatedTeacher = teacherRepository.findById(teacherId).get();
    Assert.isTrue(updatedTeacher.getPassword().equals(newPassword));
  }

  @Test
  public void testGet() {
    Integer teacherId = 2;
    Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
    Assert.notNull(optionalTeacher);
  }

  @Test
  public void testDelete() {
    Integer teacherId = 7;
    teacherRepository.deleteById(teacherId);
    Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
    Assert.isTrue(optionalTeacher.isEmpty());
  }
}
