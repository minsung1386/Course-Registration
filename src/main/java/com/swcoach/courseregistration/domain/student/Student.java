package com.swcoach.courseregistration.domain.student;

import com.swcoach.courseregistration.domain.course.Course;
import com.swcoach.courseregistration.domain.enrollment.Enrollment;
import com.swcoach.courseregistration.domain.user.jpa.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String name;

    @Column
    private String major;

    @Column
    private Long years;

    @Column
    private Double gpa;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();
}
