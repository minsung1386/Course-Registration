package com.swcoach.courseregistration.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "course")
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String instructor;

    @Column
    private Long maxCapacity;

    @Column
    private Long currentEnrolled;

    @Column
    private String schedule;

    @Column
    private Long hours;

    @Column
    private Long credit;

    @Column
    private String location;

    @OneToOne
    @JoinColumn(name="departmentId")
    private Department department;

}
