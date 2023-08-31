package com.swcoach.courseregistration.service;

import com.swcoach.courseregistration.dto.StudentDto;
import com.swcoach.courseregistration.entity.Student;
import com.swcoach.courseregistration.entity.User;
import com.swcoach.courseregistration.exception.NotFoundMemberException;
import com.swcoach.courseregistration.repository.StudentRepository;
import com.swcoach.courseregistration.repository.UserRepository;
import com.swcoach.courseregistration.util.SecurityUtil;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public StudentDto getMyStudentByUsername() {
        User user = SecurityUtil.getCurrentUsername()
                        .flatMap(userRepository::findOneWithAuthoritiesByUsername)
                        .orElseThrow(() -> new NotFoundMemberException("Member not found"));

        Student student = studentRepository.findByUserId(user.getId());
        return StudentDto.from(student);
    }

//    public List<Enrollment> getEnrollments() {
//        User user = SecurityUtil.getCurrentUsername()
//                .flatMap(userRepository::findOneWithAuthoritiesByUsername)
//                .orElseThrow(() -> new NotFoundMemberException("Member not found"));
//
//        Student student = studentRepository.findByUserId(user.getId());
//        return student.getEnrollments();
//    }
}
