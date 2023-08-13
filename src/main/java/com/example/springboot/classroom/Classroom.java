package com.example.springboot.classroom;

import javax.persistence.*;

@Entity
@Table(name = "classroom")
public class Classroom {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer assigned_teacher;
  private Integer assigned_student;
  private String class_id;

  public Classroom() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAssigned_teacher() {
    return assigned_teacher;
  }

  public void setAssigned_teacher(Integer assigned_teacher) {
    this.assigned_teacher = assigned_teacher;
  }

  public Integer getAssigned_student() {
    return assigned_student;
  }

  public void setAssigned_student(Integer assigned_student) {
    this.assigned_student = assigned_student;
  }

  public String getClass_id() {
    return class_id;
  }

  public void setClass_id(String class_id) {
    this.class_id = class_id;
  }
}
