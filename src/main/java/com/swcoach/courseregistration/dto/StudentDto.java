package com.swcoach.courseregistration.dto;


import com.swcoach.courseregistration.entity.User;

public record StudentDto(
        Long studentId,
        String name,
        String major,
        Long years,
        Double gpa,
        User user
) {}