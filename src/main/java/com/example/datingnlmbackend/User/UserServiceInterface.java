package com.example.datingnlmbackend.User;

import com.example.datingnlmbackend.Qualification.Qualification;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface UserServiceInterface {
    //User register(User user, List<String> qualifications);
    User saveUserWithQualifications(UserDTO userDTO);
    User getUserById(Long id);
    List<User> findAllUsers();
    User findUserById(Long userId);
    User findUserByFirstnameAndLastname(String firstname, String lastname);
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User save(User user);
    String updateUser(User updatedUser);
    String deleteUser(User user);
}
