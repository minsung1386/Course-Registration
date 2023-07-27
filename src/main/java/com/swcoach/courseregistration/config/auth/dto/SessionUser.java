package com.swcoach.courseregistration.config.auth.dto;

import com.swcoach.courseregistration.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String username;
    private String name;
    private String password;

    public SessionUser(User user) {
        this.username = user.getUsername();
        this.name = user.getName();
        this.password = user.getPassword();
    }
}
