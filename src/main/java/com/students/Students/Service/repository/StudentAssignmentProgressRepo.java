package com.students.Students.Service.repository;

import com.students.Students.Service.entity.StudentAssignmentProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentAssignmentProgressRepo extends JpaRepository<StudentAssignmentProgress, Long> {

    Optional <StudentAssignmentProgress> findByStudentIdAndCourseIdAndAssignmentId(Long studentId, Long courseId, Long assignmentId);
}
