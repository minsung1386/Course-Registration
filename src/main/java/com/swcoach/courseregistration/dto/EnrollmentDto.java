package com.swcoach.courseregistration.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDto {
    @NotNull
    private StudentDto studentDto;

    @NotNull
    private CourseDto courseDto;

}
