package com.example.springdatajpademo;

import com.example.springdatajpademo.entity.Student;
import com.example.springdatajpademo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository repo) {
        return args -> {
            Student student = new Student();
            student.setName("Raja Moushmi");
            student.setEmail("rajamoushmi@gmail.com");
            repo.save(student);

            System.out.println("All Students:");
            repo.findAll().forEach(s ->
                System.out.println(s.getId() + ": " + s.getName() + " - " + s.getEmail()));
        };
    }
}
