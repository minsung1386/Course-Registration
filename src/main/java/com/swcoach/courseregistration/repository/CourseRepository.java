package com.swcoach.courseregistration.repository;

import com.swcoach.courseregistration.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {
    Optional<Course> findById(String id);

    List<Course> findByDepartmentId(Long departmentId);

    List<Course> findByIdContaining(String id);

    List<Course> findByTitleContaining(String title);

    List<Course> findByInstructorContaining(String instructor);
}
