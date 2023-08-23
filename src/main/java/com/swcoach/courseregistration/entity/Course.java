package com.swcoach.courseregistration.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "course")
@Getter
public class Course {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @Column
    private String courseId;

    @Column
    private String title;

    @Column
    private Long hours;

    @Column
    private Long credit;

    @Column
    private Long currentEnrolled;

    @Column
    private Long maxCapacity;

    @Column
    private String instructor;

    @Column
    private String schedule;

    @Column
    private String description;

    @OneToOne
    @JoinColumn(name="departmentId")
    private Department department;

}
