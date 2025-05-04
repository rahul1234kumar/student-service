package com.students.Students.Service.repository;

import com.students.Students.Service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    // Custom query methods can be defined here if needed
    // For example, findByEmail(String email) to find a student by their email
    Optional<Student> findByEmail(String email);
}
