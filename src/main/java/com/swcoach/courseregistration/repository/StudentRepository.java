package com.swcoach.courseregistration.repository;

import com.swcoach.courseregistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUserId(Long userId);
}
