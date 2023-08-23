package com.swcoach.courseregistration.controller;

import com.swcoach.courseregistration.entity.Course;
import com.swcoach.courseregistration.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // ID 검색
    @GetMapping("/course/search")
    public ResponseEntity<List<Course>> findById(String courseId) {
        try {
            List<Course> searchList = courseService.findByCourseIdContaining(courseId);
            return ResponseEntity.ok(searchList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 한번에 검색
    @GetMapping("/course/total")
    public ResponseEntity<List<Course>> findByKeyword(String keyword) {
        try {
            List<Course> listById = courseService.findByCourseIdContaining(keyword);
            List<Course> listByTitle = courseService.findByTitleContaining(keyword);
            List<Course> listByInstructor = courseService.findByInstructorContaining(keyword);

            List<Course> combined = new ArrayList<>();
            combined.addAll(listById);
            combined.addAll(listByTitle);
            combined.addAll(listByInstructor);

            return ResponseEntity.ok(combined);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 부서 조회
    @GetMapping("/course/department/{departmentId}")
    public ResponseEntity<List<Course>> searchByDepartment(@PathVariable Long departmentId) {
        try {
            List<Course> searchList = courseService.searchDepartment(departmentId);
            return ResponseEntity.ok(searchList);
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
