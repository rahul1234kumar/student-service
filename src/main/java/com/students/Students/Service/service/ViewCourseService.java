package com.students.Students.Service.service;

import com.students.Students.Service.entity.Course;
import com.students.Students.Service.entity.StudentCourse;
import com.students.Students.Service.exception.CourseNotFoundException;
import com.students.Students.Service.exception.StudentNotFoundException;
import com.students.Students.Service.repository.CourseRepo;
import com.students.Students.Service.repository.StudentCourseRepo;
import com.students.Students.Service.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ViewCourseService {

    @Autowired
    private StudentCourseRepo studentCourseRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    public List<Course> viewCourses(Long studentId) {
        log.info("Viewing courses for student with ID {}", studentId);
        // Here you would typically retrieve the courses from the database
        if(studentRepo.findById(studentId).isEmpty()){
            throw new StudentNotFoundException("Student not found");
        }
        List<Course> courses = new ArrayList<>();
        List< StudentCourse> studentCourses = studentCourseRepo.findByStudentId(studentId);
        studentCourses.stream()
        .forEach(studentCourse -> {
            Course course = courseRepo.findById(studentCourse.getCourseId())
                    .orElseThrow(() -> new CourseNotFoundException("Course not found"));

            // You can set other course properties here if needed
            courses.add(course);
        });
        return courses;
    }

}
