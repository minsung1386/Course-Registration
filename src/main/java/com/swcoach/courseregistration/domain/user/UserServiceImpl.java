package com.swcoach.courseregistration.domain.user;

import com.swcoach.courseregistration.domain.user.jpa.Role;
import com.swcoach.courseregistration.domain.user.jpa.User;
import com.swcoach.courseregistration.domain.user.jpa.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(String username, String password, String name, String contact) {
        User user = new User(username, passwordEncoder.encode(password), name, contact, Role.USER);

        this.userRepository.save(user);
        return user;
    }
}
