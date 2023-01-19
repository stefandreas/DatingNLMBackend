package com.example.datingnlmbackend.User;

public interface UserServiceInterface {
    User login(String username, String password);

    User register(String firstname, String lastname, String username, String email, String password);
}
