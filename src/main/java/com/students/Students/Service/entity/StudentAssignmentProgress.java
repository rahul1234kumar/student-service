package com.students.Students.Service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "student_assignment_progress")
@Data
public class StudentAssignmentProgress  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment for MySQL
    private Long id;
    private Long studentId;
    private Long courseId;
    private Long assignmentId;
    private LocalDate updatedAt;
    private LocalDate dueDate;
    private String status;
    private String reviewStatus;
    private int submitCount=0;// Completed, In Progress, etc.
    private String grade; // Optional field for storing grades or scores
}
