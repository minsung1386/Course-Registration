package com.swcoach.courseregistration.controller;

import com.swcoach.courseregistration.service.CourseService;
import com.swcoach.courseregistration.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegistrationController {

    private final CourseService courseService;
    private final StudentService studentService;

//    @GetMapping("/register")
//    public ResponseEntity<String> register(String courseId) {
//        // 해당 과목 특정
//        Course course = courseService.findById(courseId).orElseThrow();
//
//        // 과목 수강신청 불가
//        if(course.getCurrentEnrolled() >= course.getMaxCapacity()) {
//            return ResponseEntity.badRequest().body("수강 가능 정원이 초과했습니다.");
//        }
//
//        // 학생 정보 특정
//        StudentDto studentDto = studentService.getMyStudentByUsername();
//
//        // 학생의 수강 과목 목록에 과목 추가
//        List<Enrollment> enrollments = studentDto.getEnrollmentsDto();
//
//        if (!enrollments.contains(course)) {
//            enrollments.add(course);
//            studentService.save(student.get());  // 학생 정보 업데이트
//            return ResponseEntity.ok("수강신청 완료");
//        } else {
//            return ResponseEntity.badRequest().body("이미 수강신청한 과목");
//        }
//    }

}
