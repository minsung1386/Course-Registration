package com.swcoach.courseregistration.config.auth.dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class SessionUser extends org.springframework.security.core.userdetails.User {
    private final String name;
    private final String contact;

    public SessionUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String name, String contact) {
        super(username, password, authorities);
        this.name = name;
        this.contact = contact;
    }

    // User 인자로 받는 생성자


//    private String password;

//    public SessionUser(User user) {
//        this.username = user.getUsername();
//        this.name = user.getName();
//        this.password = user.getPassword();
//    }

}
