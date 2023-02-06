package com.example.datingnlmbackend.UserPreferences;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrefRepository extends JpaRepository<UserPreferences,Long> {
    UserPreferences findUserPreferencesByUserId(Long userId);
    UserPreferences findUserPreferencesById(Long id);
}
