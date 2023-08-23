package com.swcoach.courseregistration.dto;

public record CourseDto(
//        Long id,
        String courseId,
        String title,
        Long hours,
        Long credit,
        Long currentEnrolled,
        Long maxCapacity,
        String instructor,
        String schedule,
        String description
) {}
