package com.swcoach.courseregistration.domain.course;

public record CourseDto(
        Long id,
        String courseName,
        String description,
        String instructor,
        Long maxCapacity,
        Long currentEnrolled,
        String schedule,
        Long hours,
        Long credit,
        String location
) {}
