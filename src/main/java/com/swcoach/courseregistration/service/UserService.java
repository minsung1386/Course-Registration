package com.swcoach.courseregistration.service;

import com.swcoach.courseregistration.domain.user.Role;
import com.swcoach.courseregistration.domain.user.User;
import com.swcoach.courseregistration.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User create(String username, String password, String name, String contact) {
        User user = new User(username, passwordEncoder.encode(password), name, contact);
        user.setRole(Role.USER);
        this.userRepository.save(user);
        return user;
    }
}
