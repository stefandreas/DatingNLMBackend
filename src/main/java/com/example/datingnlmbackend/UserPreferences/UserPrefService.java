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

    @Override
    public UserPreferences findUserPreferencesById(Long id) {
        return userPrefRepository.findUserPreferencesById(id);
    }

    @Override
    public String updatePrefs(UserPreferences userPreferences) {
        UserPreferences updatedUserPref = findUserPreferencesById(userPreferences.getId());
        updatedUserPref.p1 = userPreferences.p1;
        updatedUserPref.p2 = userPreferences.p2;
        updatedUserPref.p3 = userPreferences.p3;
        updatedUserPref.p4 = userPreferences.p4;
        updatedUserPref.p5 = userPreferences.p5;
        userPrefRepository.save(updatedUserPref);
        return "Preferences have been updated";
    }
}
