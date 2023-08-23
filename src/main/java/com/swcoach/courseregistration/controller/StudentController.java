package com.swcoach.courseregistration.controller;


import com.swcoach.courseregistration.dto.StudentDto;
import com.swcoach.courseregistration.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<StudentDto> getMyStudentInfo() {
        return ResponseEntity.ok(studentService.getMyStudentByUsername());
    }
}
