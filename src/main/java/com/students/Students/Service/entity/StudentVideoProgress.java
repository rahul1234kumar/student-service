package com.students.Students.Service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "student_video_progress")
 @Data
public class StudentVideoProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment for MySQL
    private Long id;
    private Long studentId;
    private Long courseId;
    private Long videoId;
    private LocalDate updatedAt;
    private String status; // Completed, In Progress, etc.
    private Double watchedTime;
}
