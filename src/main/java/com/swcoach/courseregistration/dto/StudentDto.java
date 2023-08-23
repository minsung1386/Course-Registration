package com.swcoach.courseregistration.dto;

import com.swcoach.courseregistration.entity.Enrollment;
import com.swcoach.courseregistration.entity.Student;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentDto {
    private String major;
    private Long years;
    private Double gpa;
    private String idNum;
    private List<Enrollment> enrollmentsDto;
    private UserDto userDto;

    public static StudentDto from(Student student) {
        if(student == null) return null;

        return StudentDto.builder()
                .major(student.getMajor())
                .years(student.getYears())
                .gpa(student.getGpa())
                .idNum(student.getIdNum())
                .enrollmentsDto(student.getEnrollments())
                .userDto(UserDto.from(student.getUser()))
                .build();
    }
}
