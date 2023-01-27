package com.example.datingnlmbackend.User;

import com.example.datingnlmbackend.Qualification.Qualification;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface UserServiceInterface {
    //User register(User user, List<String> qualifications);
    User saveUserWithQualifications(UserDTO userDTO);

    User getUserById(Long id);
    User findUserById(Long userId);
    User findUserByFirstnameAndLastname(String firstname, String lastname);
    void save(User user);
    ResponseEntity<User> updateUser(User updatedUser);
    String deleteUser(User user);
}
