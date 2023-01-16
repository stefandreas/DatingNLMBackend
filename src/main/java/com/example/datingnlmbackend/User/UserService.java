package com.example.datingnlmbackend.User;

import org.springframework.stereotype.Service;

@Service

public class UserService implements UserServiceInterface{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
