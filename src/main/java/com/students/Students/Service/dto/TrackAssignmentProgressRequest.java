package com.students.Students.Service.dto;

import lombok.Data;

@Data
public class TrackAssignmentProgressRequest {
    private Long assignmentId;
    private String status; // Completed, In Progress, etc.
}
