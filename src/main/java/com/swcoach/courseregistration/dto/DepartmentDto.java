package com.swcoach.courseregistration.dto;

import com.swcoach.courseregistration.entity.Course;

import java.util.List;

public record DepartmentDto (
        Long departmentId,
        String departmentName,
        List<Course> courses
){}
