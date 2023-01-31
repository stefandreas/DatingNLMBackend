package com.example.datingnlmbackend.UserPreferences;

import org.springframework.stereotype.Service;

@Service
public class UserPrefService implements UserPrefServiceInterface{
    private final UserPrefRepository userPrefRepository;

    public UserPrefService(UserPrefRepository userPrefRepository) {
        this.userPrefRepository = userPrefRepository;
    }
    public UserPreferences findUserPreferencesByUserId(Long userId){
        return userPrefRepository.findUserPreferencesByUserId(userId);
    }
    public String save(UserPreferences userPreferences){
        userPrefRepository.save(userPreferences);
        return "UserPreferences saved";
    }
}
