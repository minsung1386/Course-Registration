package com.swcoach.courseregistration.dto;

import com.swcoach.courseregistration.entity.Student;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentDto {
    private String major;
    private Long years;
    private Double gpa;
    private String idNum;
    private UserDto userDto;

    public static StudentDto from(Student student) {
        if(student == null) return null;

        return StudentDto.builder()
                .major(student.getMajor())
                .years(student.getYears())
                .gpa(student.getGpa())
                .idNum(student.getIdNum())
                .userDto(UserDto.from(student.getUser()))
                .build();
    }
}
