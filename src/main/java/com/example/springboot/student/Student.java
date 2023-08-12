package com.example.springboot.student;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 15)
  private String firstName;

  @Column(nullable = false, length = 15)
  private String lastName;

  @Transient private Integer age;

  @Column(nullable = false, length = 15)
  private LocalDate dob;

  @Column(nullable = false, unique = true, length = 35)
  private String email;

  private boolean enabled;

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public Student(String firstName, String lastName, LocalDate dob, String email, Boolean enabled) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.email = email;
    this.enabled = enabled;
  }

  public Student(
      Integer id, String firstName, String lastName, LocalDate dob, String email, Boolean enabled) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.email = email;
    this.enabled = enabled;
  }

  public Student() {}

  @Override
  public String toString() {
    return "Student{"
        + "id="
        + id
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
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

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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
