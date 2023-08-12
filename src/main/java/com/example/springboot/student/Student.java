package com.example.springboot.student;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.*;

@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(name = "sys_sequence", sequenceName = "sys_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sys_sequence")
  private Integer id;

  private String name;
  @Transient private Integer age;
  private LocalDate dob;
  private String email;

  public Student(String name, LocalDate dob, String email) {
    this.name = name;
    this.dob = dob;
    this.email = email;
  }

  public Student(Integer id, String name, LocalDate dob, String email) {
    this.id = id;
    this.name = name;
    this.dob = dob;
    this.email = email;
  }

  public Student() {}

  @Override
  public String toString() {
    return "Student{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", age="
        + age
        + ", dob="
        + dob
        + ", email='"
        + email
        + '\''
        + '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return Period.between(this.dob, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
