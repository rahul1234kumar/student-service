package com.students.Students.Service.controllers;

import com.students.Students.Service.entity.Course;
import com.students.Students.Service.entity.Student;
import com.students.Students.Service.service.EnrollService;
import com.students.Students.Service.service.StudentService;
import com.students.Students.Service.service.ViewCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/")

public class RegisterStudent {

     @Autowired
     private EnrollService enrollService;

     @Autowired
     private ViewCourseService viewCourseService;

     @Autowired
     private StudentService studentService;

    @PostMapping("/enroll/{studentId}/{courseId}")
    public String enrollStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        log.info("Enrolling student with ID {} in course with ID {}", studentId, courseId);
        enrollService.enrollStudent(studentId, courseId);
        return "Student enrolled successfully!";
    }

    @GetMapping("/view_courses/{studentId}")
    public List<Course> viewCourses(@PathVariable Long studentId) {
        log.info("Viewing courses for student with ID {}", studentId);
        return ResponseEntity.ok(viewCourseService.viewCourses(studentId)).getBody();
    }

    @PostMapping("/create_student")
    public String createStudent(@RequestBody Student student) {
        log.info("Creating student: {}", student);
        studentService.createStudent(student);
        return "Student created successfully!";
    }
    @GetMapping("/view_student/{studentId}")
    public Student viewStudentById(@PathVariable Long studentId) {
        log.info("Viewing student with ID {}", studentId);
        return ResponseEntity.ok(studentService.viewStudentById(studentId)).getBody();
    }
    @PostMapping("/update_student/{studentId}")
    public String updateStudent(@RequestBody Student student, @PathVariable Long studentId) {
        log.info("Updating student with ID {}", studentId);
        studentService.updateStudent(student, studentId);
        return "Student updated successfully!";
    }
    @DeleteMapping("/delete_student/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        log.info("Deleting student with ID {}", studentId);
        studentService.deleteStudent(studentId);
        return "Student deleted successfully!";
    }

}
