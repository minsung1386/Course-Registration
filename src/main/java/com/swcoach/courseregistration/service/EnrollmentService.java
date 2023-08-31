package com.swcoach.courseregistration.service;

import com.swcoach.courseregistration.entity.Enrollment;
import com.swcoach.courseregistration.entity.Student;
import com.swcoach.courseregistration.entity.User;
import com.swcoach.courseregistration.exception.NotFoundMemberException;
import com.swcoach.courseregistration.repository.EnrollmentRepository;
import com.swcoach.courseregistration.repository.StudentRepository;
import com.swcoach.courseregistration.repository.UserRepository;
import com.swcoach.courseregistration.util.SecurityUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(StudentRepository studentRepository, UserRepository userRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> listUp() {
        User user = SecurityUtil.getCurrentUsername()
                .flatMap(userRepository::findOneWithAuthoritiesByUsername)
                .orElseThrow(() -> new NotFoundMemberException("Member not found"));

        Student student = studentRepository.findByUserId(user.getId());
//        return enrollmentRepository.findAllByStudentId(student.getId());
        return student.getEnrollments();
    }
}
