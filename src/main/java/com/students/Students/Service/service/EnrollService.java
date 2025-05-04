package com.students.Students.Service.service;

import com.students.Students.Service.entity.Course;
import com.students.Students.Service.entity.Student;
import com.students.Students.Service.entity.StudentCourse;
import com.students.Students.Service.exception.CourseNotFoundException;
import com.students.Students.Service.exception.StudentNotFoundException;
import com.students.Students.Service.repository.CourseRepo;
import com.students.Students.Service.repository.StudentCourseRepo;
import com.students.Students.Service.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class EnrollService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentCourseRepo studentCourseRepo;

    @Autowired
    private CourseRepo courseRepo;

    public String registerStudent(Student student) {
        log.info("Registering student: {}", student);
        // Here you would typically save the student to the database
        return "Student registered successfully!";
    }
    public String enrollStudent(Long studentId, Long courseId) throws StudentNotFoundException, CourseNotFoundException {
        log.info("Enrolling student with ID {} in course with ID {}", studentId, courseId);
        //check if student exists
        try {
            Student student = studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException(String.format("Student with ID %d does not exist", studentId)));
            Course course = courseRepo.findById(courseId).orElseThrow(() -> new CourseNotFoundException(String.format("Course with ID %d does not exist", courseId)));
            List<StudentCourse> courses = studentCourseRepo.findByStudentId(studentId);
            boolean isEnrolled = courses.stream().anyMatch(studentCourse -> studentCourse.getCourseId().equals(courseId));
            // boolean success = paymentService.processPayment(studentId, courseId);
            if (!isEnrolled) {
                StudentCourse studentCourse = new StudentCourse();
                studentCourse.setStudentId(studentId);
                studentCourse.setCourseId(courseId);
                //if success
                studentCourse.setStatus("Enrolled");
                studentCourse.setCreatedAt(LocalDateTime.now().toString());
                studentCourseRepo.save(studentCourse);
            }
        } catch (StudentNotFoundException | CourseNotFoundException e) {
            log.error("Error enrolling student: {}", e.getMessage());
            throw e;
        }
        return "Student enrolled successfully!";
    }
}
