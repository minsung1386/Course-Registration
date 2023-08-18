package com.swcoach.courseregistration.domain.department;

import com.swcoach.courseregistration.domain.course.Course;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String departmentName;

    @OneToMany
    @JoinColumn(name = "courseId")
    private List<Course> courseList = new ArrayList<>();
}
