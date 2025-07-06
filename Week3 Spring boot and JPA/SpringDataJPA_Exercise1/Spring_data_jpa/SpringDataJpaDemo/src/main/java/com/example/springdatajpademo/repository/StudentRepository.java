package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
