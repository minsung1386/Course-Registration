package com.swcoach.courseregistration.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "student")
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column
    private String major;

    @Column
    private Long years;

    @Column
    private Double gpa;

    @Column
    private String idNum;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
