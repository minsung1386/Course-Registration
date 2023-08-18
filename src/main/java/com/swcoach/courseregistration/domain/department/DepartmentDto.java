package com.swcoach.courseregistration.domain.department;

import com.swcoach.courseregistration.domain.course.Course;

import java.util.List;

public record DepartmentDto (
        Long departmentId,
        String departmentName,
        List<Course> courses
){}
