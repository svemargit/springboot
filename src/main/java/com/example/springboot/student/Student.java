package com.example.springboot.student;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
  @Id
  @SequenceGenerator(name = "sys_sequence", sequenceName = "sys_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sys_sequence")
  private Integer id;

  private String firstName;
  private String lastName;
  @Transient private Integer age;
  private LocalDate dob;
  private String email;

  public Student(String firstName, String lastName, LocalDate dob, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.email = email;
  }

  public Student(Integer id, String firstName, String lastName, LocalDate dob, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.email = email;
  }

  public Student() {}

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            ", dob=" + dob +
            ", email='" + email + '\'' +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String firstName) {
    this.firstName = firstName;
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
