package com.example.datingnlmbackend.UserQualifications;

import com.example.datingnlmbackend.User.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userQ")
public class UserQController {
    private final UserQService userQService;

    public UserQController(UserQService userQService) {
        this.userQService = userQService;
    }

        @GetMapping("/findUserQualificationsByUserId")
          public UserQualifications findUserQualificationsByUserId(Long userId){
                return userQService.findUserQualificationsByUserId(userId);
        }
        @PostMapping(value = "/save", consumes = "application/json")
           public String save(@RequestBody UserQualifications userQualifications){
                return userQService.save(userQualifications);
        }
        @GetMapping("/findAll")
            public List<UserQualifications> findAll(){
                return userQService.findAll();
        }
        @GetMapping("/findAllUsersWithSpecificQualification")
            public List<User> findAllUsersWithSpecificQualification(String q){
                return userQService.findAllUsersWithSpecificQualification(q);
        }
        @GetMapping("/findAllUsersWithXNrQualifications")
            public List<User> findAllUsersWithXNrQualifications(ArrayList<String> qualificationArray){
                return userQService.findAllUsersWithXNrQualifications(qualificationArray);
        }
}
