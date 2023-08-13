package com.example.springboot.classroom;

import javax.persistence.*;

@Entity
public class Classroom {
  @Id
  @Column(name = "class_id")
  private String classId;

  @Column(name = "teacher_full_name")
  private String teacherFullName;

  @Column(name = "student_names")
  private String studentNames;

  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }

  public String getTeacherFullName() {
    return teacherFullName;
  }

  public void setTeacherFullName(String teacherFullName) {
    this.teacherFullName = teacherFullName;
  }

  public String getStudentNames() {
    return studentNames;
  }

  public void setStudentNames(String studentNames) {
    this.studentNames = studentNames;
  }
}
