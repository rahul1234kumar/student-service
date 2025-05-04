package com.students.Students.Service.repository;

import com.students.Students.Service.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, Long> {
    // Custom query methods can be defined here if needed
    // For example, findByStudentId(Long studentId) to find courses by a specific student
    List<StudentCourse> findByStudentId(Long studentId);
}
