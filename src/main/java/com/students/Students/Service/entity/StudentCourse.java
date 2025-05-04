package com.students.Students.Service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_course")
@Data
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private Long courseId;
    private String createdAt;
    private String updatedAt;

    private String status; // Enrolled, Completed, etc.
    private String grade; // Optional field for storing grades or scores
}
