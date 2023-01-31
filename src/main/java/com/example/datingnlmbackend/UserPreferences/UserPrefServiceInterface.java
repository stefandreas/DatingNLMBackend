package com.example.datingnlmbackend.UserPreferences;

public interface UserPrefServiceInterface {
    UserPreferences findUserPreferencesByUserId(Long userId);
    String save(UserPreferences userPreferences);
}
