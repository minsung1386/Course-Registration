package com.swcoach.courseregistration.domain.student;

import com.swcoach.courseregistration.domain.user.jpa.User;

public record StudentDto(
        Long studentId,
        String name,
        String major,
        Long years,
        Double gpa,
        User user
) {}