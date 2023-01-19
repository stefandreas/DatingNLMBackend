package com.example.datingnlmbackend.User;

import org.springframework.http.ResponseEntity;

public interface UserServiceInterface {
    User login(String username, String password);

    User register(User user);
}
