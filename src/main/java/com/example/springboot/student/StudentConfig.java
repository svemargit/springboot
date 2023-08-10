package com.example.springboot.student;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      Student martin =
          new Student("Martin Svejda", LocalDate.of(1995, JANUARY, 5), "svejdam@icloud.com");
      Student ichtyl =
          new Student("Ichtyl Ochan", LocalDate.of(1993, FEBRUARY, 28), "iuchtyl@icloud.com");
      repository.saveAll(List.of(martin, ichtyl));
    };
  }
}
