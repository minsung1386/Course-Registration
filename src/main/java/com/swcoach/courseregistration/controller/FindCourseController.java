package com.swcoach.courseregistration.controller;

import com.swcoach.courseregistration.entity.Course;
import com.swcoach.courseregistration.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FindCourseController {

    private final CourseService courseService;

    // id 조회
//    @GetMapping("/api/v1/course/{id}")
//    public CourseResponseDto findById(@PathVariable Long id) {
//        return courseService.findById(id);
//    }

    // 검색어 조회
    @GetMapping("/api/v1/course/search")
    public ResponseEntity<List<Course>> searchByName(String keyword) {
        try {
            List<Course> searchList = courseService.searchKeyword(keyword);
            return ResponseEntity.ok(searchList);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 부서 조회
    @GetMapping("/api/v1/course/{departmentId}")
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
