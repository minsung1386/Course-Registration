package com.swcoach.courseregistration.controller;


import com.swcoach.courseregistration.dto.StudentDto;
import com.swcoach.courseregistration.entity.Enrollment;
import com.swcoach.courseregistration.service.EnrollmentService;
import com.swcoach.courseregistration.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    public StudentController(StudentService studentService, EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/student")
    public ResponseEntity<StudentDto> getMyStudentInfo() {
        return ResponseEntity.ok(studentService.getMyStudentByUsername());
    }

    // 신청 내역 조회
    @GetMapping("/registered")
    public ResponseEntity<List<Enrollment>> getMyRegistration() {

        System.out.println("This is student below");
        return ResponseEntity.ok(enrollmentService.listUp());
    }
}
