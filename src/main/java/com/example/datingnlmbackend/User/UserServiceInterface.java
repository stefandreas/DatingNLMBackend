package com.example.datingnlmbackend.User;

import org.springframework.http.ResponseEntity;

public interface UserServiceInterface {
    User findUserById(Long userId);
    User findUserByFirstnameAndLastname(String firstname, String lastname);
    void save(User user);
    ResponseEntity<User> updateUser(User updatedUser);
    String deleteUser(User user);
}
