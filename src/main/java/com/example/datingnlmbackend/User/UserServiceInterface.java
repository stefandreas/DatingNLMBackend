package com.example.datingnlmbackend.User;

import com.example.datingnlmbackend.Qualification.Qualification;

import java.util.List;

public interface UserServiceInterface {
    //User register(User user, List<String> qualifications);
    User saveUserWithQualifications(UserDTO userDTO);

    User getUserById(Long id);
}
