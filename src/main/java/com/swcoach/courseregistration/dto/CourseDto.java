package com.swcoach.courseregistration.dto;

import com.swcoach.courseregistration.entity.Course;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private String title;
    private Long hours;
    private Long credit;
    private Long currentEnrolled;
    private Long maxCapacity;
    private String instructor;
    private String schedule;
    private String description;

    public static CourseDto from(Course course) {
        if(course == null) return null;

        return CourseDto.builder()
                .title(course.getTitle())
                .hours(course.getHours())
                .credit(course.getCredit())
                .currentEnrolled(course.getCurrentEnrolled())
                .maxCapacity(course.getMaxCapacity())
                .instructor(course.getInstructor())
                .schedule(course.getSchedule())
                .description(course.getDescription())
                .build();
    }
}
