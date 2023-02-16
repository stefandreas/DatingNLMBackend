package com.example.datingnlmbackend.UserQualifications;


import com.example.datingnlmbackend.User.User;

import java.util.ArrayList;
import java.util.List;

public interface UserQServiceInterface {
    UserQualifications findUserQualificationsByUserId(Long userId);
    void save(UserQualifications userQualifications);
    List<UserQualifications> findAll();
    List<User> findAllUsersWithSpecificQualification(String q);
    List<User> findAllUsersWithXNrQualifications(ArrayList<String> qualificationArray);
}
