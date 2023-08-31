package com.swcoach.courseregistration.entity;

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
    @JoinColumn(name = "course_id")
    private List<Course> courseList = new ArrayList<>();
}
