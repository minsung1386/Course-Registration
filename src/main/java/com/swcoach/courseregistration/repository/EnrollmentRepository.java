package com.swcoach.courseregistration.repository;

import com.swcoach.courseregistration.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findAllByStudentId(Long studentId);
}
