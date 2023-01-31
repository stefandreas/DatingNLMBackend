package com.example.datingnlmbackend.UserPreferences;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userPref")
public class UserPrefController {
    private final UserPrefService userPrefService;

    public UserPrefController(UserPrefService userPrefService) {
        this.userPrefService = userPrefService;
    }
    @GetMapping("/findUserPreferencesByUserId")
    public UserPreferences findUserPreferencesByUserId(Long userId){
        return userPrefService.findUserPreferencesByUserId(userId);
    }
    @PostMapping(value = "/save", consumes = "application/json")
    public String save(@RequestBody UserPreferences userPreferences){
        return userPrefService.save(userPreferences);
    }
}
