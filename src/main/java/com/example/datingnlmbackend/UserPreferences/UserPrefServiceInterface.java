package com.example.datingnlmbackend.UserPreferences;

public interface UserPrefServiceInterface {
    UserPreferences findUserPreferencesByUserId(Long userId);
    UserPreferences findUserPreferencesById(Long id);
    String save(UserPreferences userPreferences);
    String updatePrefs(UserPreferences userPreferences);
}
