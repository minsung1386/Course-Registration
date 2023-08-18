package com.swcoach.courseregistration.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {


    List<Course> findByTitleContaining(String keyword);

    List<Course> findByDepartmentId(Long departmentId);
}
