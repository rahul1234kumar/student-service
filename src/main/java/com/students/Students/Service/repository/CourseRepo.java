package com.students.Students.Service.repository;

import com.students.Students.Service.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
    // Custom query methods can be defined here if needed
    // For example, findByTeacherId(Long teacherId) to find courses by a specific teacher
    List<Course> findByTeacherId(Long teacherId);
}
