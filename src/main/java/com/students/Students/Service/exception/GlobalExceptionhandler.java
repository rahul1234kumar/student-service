package com.students.Students.Service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler{
    // Handle specific exceptions and return appropriate responses
    // For example, handle StudentNotFoundException, CourseNotFoundException, etc.

    // Example of a custom exception handler
     @ExceptionHandler(StudentNotFoundException.class)
     public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
     }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> handleCourseNotFound(CourseNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Add more exception handlers as needed

}
