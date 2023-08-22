package com.swcoach.courseregistration.service;

import com.swcoach.courseregistration.entity.Course;
import com.swcoach.courseregistration.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> searchKeyword(String keyword) {
        return courseRepository.findByTitleContaining(keyword);
    }

    public List<Course> searchDepartment(Long departmentId) {
        return courseRepository.findByDepartmentId(departmentId);
    }
}
