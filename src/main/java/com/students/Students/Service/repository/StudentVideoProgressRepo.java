package com.students.Students.Service.repository;

import com.students.Students.Service.entity.StudentVideoProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StudentVideoProgressRepo extends JpaRepository<StudentVideoProgress, Long> {
    Optional<StudentVideoProgress> findByStudentIdAndCourseIdAndVideoId(Long studentId, Long courseId, Long videoId);
    // Custom query methods can be defined here if needed
    // For example, findByStudentIdAndCourseId(Long studentId, Long courseId) to find progress for a specific student and course
}
