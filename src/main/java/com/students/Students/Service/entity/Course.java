package com.students.Students.Service.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_info")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    @Column(name = "teacher_id", nullable = false)
    private Long teacherId;

    private LocalDateTime createdAt = LocalDateTime.now();
}

