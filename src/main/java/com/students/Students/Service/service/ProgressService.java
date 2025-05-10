package com.students.Students.Service.service;

import com.students.Students.Service.entity.StudentAssignmentProgress;
import com.students.Students.Service.entity.StudentVideoProgress;
import com.students.Students.Service.repository.StudentAssignmentProgressRepo;
import com.students.Students.Service.repository.StudentVideoProgressRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class ProgressService {
    @Autowired
    private StudentAssignmentProgressRepo studentAssignmentRepo;
    @Autowired
    StudentVideoProgressRepo studentVideoProgressRepo;

    public void submitAssignmentProgress(Long studentId, Long courseId, Long assignmentId, String status) {
        log.info("Submitting assignment progress for student ID: {}, course ID: {}, assignment ID: {}, status: {}", studentId, courseId, assignmentId, status);
        // Logic to save assignment progress
        // Example: studentAssignmentRepo.save(new StudentAssignmentProgress(studentId, courseId, assignmentId, status));
        StudentAssignmentProgress studentAssignmentProgress = studentAssignmentRepo.findByStudentIdAndCourseIdAndAssignmentId(studentId, courseId, assignmentId)
                .orElse(new StudentAssignmentProgress());
        if(studentAssignmentProgress.getSubmitCount()>3 && status.equalsIgnoreCase("Submitted")) {
            log.info("Student has already submitted the assignment 3 times");
            throw new IllegalArgumentException("Student has already submitted the assignment 3 times");
        }

        studentAssignmentProgress.setStudentId(studentId);
        studentAssignmentProgress.setCourseId(courseId);
        studentAssignmentProgress.setAssignmentId(assignmentId);
        studentAssignmentProgress.setStatus(status);
        studentAssignmentProgress.setUpdatedAt(LocalDate.now());
        studentAssignmentProgress.setSubmitCount(studentAssignmentProgress.getSubmitCount() + 1);
        studentAssignmentRepo.save(studentAssignmentProgress);
    }

    public void  submitVideoProgress(Long studentId, Long courseId, Long videoId, Double watchTime) {
        log.info("Submitting video progress for student ID: {}, course ID: {}, video ID: {}, status: {}", studentId, courseId, videoId, watchTime);
        // Logic to save video progress
        // Example: studentVideoProgressRepo.save(new StudentVideoProgress(studentId, courseId, videoId, status));
        StudentVideoProgress studentVideoProgress = studentVideoProgressRepo.findByStudentIdAndCourseIdAndVideoId(studentId, courseId, videoId)
                .orElse(new StudentVideoProgress());
        studentVideoProgress.setCourseId(courseId);
        studentVideoProgress.setStudentId(studentId);
        studentVideoProgress.setVideoId(videoId);
        studentVideoProgress.setWatchedTime(watchTime);
        studentVideoProgress.setUpdatedAt(LocalDate.now());
        studentVideoProgressRepo.save(studentVideoProgress);
       // fetch duration of video from other service to mark it as completed


    }
}
