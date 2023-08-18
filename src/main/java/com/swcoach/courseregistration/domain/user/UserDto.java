package com.swcoach.courseregistration.domain.user;

public record UserDto(
        String username,
        String name,
        String contact,
        String password,
        String password2
) {
}