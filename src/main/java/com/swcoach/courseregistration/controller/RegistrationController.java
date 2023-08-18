package com.swcoach.courseregistration.controller;

import com.swcoach.courseregistration.domain.course.Course;
import com.swcoach.courseregistration.domain.course.CourseDto;
import com.swcoach.courseregistration.domain.student.Student;
import com.swcoach.courseregistration.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

//    private final CourseService courseService;
//    private final StudentService studentService;
//
//    @GetMapping("/api/v1/register/{courseId}")
//    public ResponseEntity<String> register(@PathVariable Long courseId) {
//        // 해당 과목 특정
//        Optional<Course> course = courseService.findById(courseId);
//
//        // 과목의 정보가 유효한지 확인
//        if (course.isEmpty()) {
//            return ResponseEntity.badRequest().body("해당 과목 없음");
//        }
//
//        // 학생 정보 특정
//        Long studentId = 1L; // 임의
//        Optional<Student> student = studentService.findById(studentId);
//
//        // 학생 정보 validation
//        if (student.isEmpty()) {
//            return ResponseEntity.badRequest().body("학생 정보 없음.");
//        }
//
//        // 학생의 수강 과목 목록에 과목 추가
//        List<Course> enrolledCourses = student.get().getEnrolledCourses();
//        if (!enrolledCourses.contains(course.get())) {
//            enrolledCourses.add(course.get());
//            studentService.save(student.get());  // 학생 정보 업데이트
//            return ResponseEntity.ok("수강신청 완료");
//        } else {
//            return ResponseEntity.badRequest().body("이미 수강신청한 과목");
//        }
//    }

}
