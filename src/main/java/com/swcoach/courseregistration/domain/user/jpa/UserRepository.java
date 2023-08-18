package com.swcoach.courseregistration.domain.user.jpa;

import com.swcoach.courseregistration.domain.user.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}