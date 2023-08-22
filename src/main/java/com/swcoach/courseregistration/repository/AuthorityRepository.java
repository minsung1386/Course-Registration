package com.swcoach.courseregistration.repository;


import com.swcoach.courseregistration.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
