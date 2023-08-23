package com.swcoach.courseregistration.service;

import com.swcoach.courseregistration.entity.Course;
import com.swcoach.courseregistration.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    // 소속 학부 조회
    public List<Course> searchDepartment(Long departmentId) {
        return courseRepository.findByDepartmentId(departmentId);
    }

    public Optional<Course> findById(String courseId) {
        return courseRepository.findById(courseId);
    }

    // 학수번호 검색
    @Transactional
    public List<Course> findByCourseIdContaining(String courseId) {
        List<Course> courseList = courseRepository.findByCourseIdContaining(courseId);
        return courseList;
    }

    // 과목명 검색
    @Transactional
    public List<Course> findByTitleContaining(String title) {
        List<Course> courseList = courseRepository.findByTitleContaining(title);
        return courseList;
    }

    // 교강사 검색
    @Transactional
    public List<Course> findByInstructorContaining(String instructor) {
        List<Course> courseList = courseRepository.findByInstructorContaining(instructor);
        return courseList;
    }
}
