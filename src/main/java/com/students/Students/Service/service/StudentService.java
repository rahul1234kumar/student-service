package com.students.Students.Service.service;

import com.students.Students.Service.entity.Student;
import com.students.Students.Service.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    // Method to create a new student
    public void createStudent(Student student) {
        log.info("Creating student: {}", student);
        // Save the student to the database
        studentRepo.save(student);
    }
    // Method to view a student by ID
    public Student viewStudentById(Long studentId) {
        log.info("Viewing student with ID {}", studentId);
        // Find the student by ID
        return studentRepo.findById(studentId).orElse(null);
    }
    // Method to update a student
    public Student updateStudent(Student student, Long studentId) {
        log.info("Updating student with ID {}", studentId);
        // Find the student by ID
        Student existingStudent = studentRepo.findById(studentId).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPassword(student.getPassword());
            // Save the updated student to the database
            return studentRepo.save(existingStudent);
        }
        return null;
    }
    // Method to delete a student
    public void deleteStudent(Long studentId) {
        log.info("Deleting student with ID {}", studentId);
        // Delete the student from the database
        studentRepo.deleteById(studentId);
    }

}
