package com.swcoach.courseregistration.domain.user;

import com.swcoach.courseregistration.domain.user.jpa.User;

public interface UserService {
    User create(String username, String password, String name, String contact);
}
