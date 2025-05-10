package com.students.Students.Service.controllers;

import com.students.Students.Service.dto.TrackAssignmentProgressRequest;
import com.students.Students.Service.dto.TrackVideoRequest;
import com.students.Students.Service.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/progress")
public class ProgressController {
    // This controller will handle the progress tracking for students
    // You can define endpoints for tracking video and assignment progress here

    // Example endpoint for tracking video progress
     @Autowired
     private ProgressService progressService;
     @PostMapping("/video/{studentId}/{courseId}")
     public ResponseEntity<String> trackVideoProgress(@PathVariable Long studentId,@PathVariable Long courseId, @RequestBody TrackVideoRequest trackVideoRequest) {
         // Logic to track video progress
         progressService.submitVideoProgress(studentId, courseId,trackVideoRequest.getVideoId(), trackVideoRequest.getWatchedTime());
         return ResponseEntity.ok("Video progress tracked successfully");
     }

    // Example endpoint for tracking assignment progress
     @PostMapping("/assignment/{studentId}/{courseId}")
     public ResponseEntity<String> progressAssignmet(@PathVariable Long studentId, @PathVariable Long courseId, @RequestBody TrackAssignmentProgressRequest trackAssignmentProgressRequest
                                                     ) {
         // Logic to track assignment progress
         progressService.submitAssignmentProgress(studentId, courseId,  trackAssignmentProgressRequest.getAssignmentId(), trackAssignmentProgressRequest.getStatus());
         return ResponseEntity.ok("Assignment progress tracked successfully");
     }
}
