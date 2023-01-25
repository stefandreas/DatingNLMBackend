package com.example.datingnlmbackend.UserQualifications;

import com.example.datingnlmbackend.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/userQ")
public class UserQController {
    UserQService userQService;

    public UserQController(UserQService userQService) {
        this.userQService = userQService;
    }
        @GetMapping("/findUserQualificationsByUserId")
            UserQualifications findUserQualificationsByUserId(Long userId){
                return userQService.findUserQualificationsByUserId(userId);
        }
        @PostMapping("/save")
            void save(@RequestBody UserQualifications userQualifications){
                userQService.save(userQualifications);
        }
        @GetMapping("/findAll")
    List<UserQualifications> findAll(){
        return userQService.findAll();
        }
        @GetMapping("/findAllUsersWithSpecificQualification")
    List<User> findAllUsersWithSpecificQualification(String q){
            return userQService.findAllUsersWithSpecificQualification(q);
        }
        @GetMapping("/findAllUsersWithXNrQualifications")
    List<User> findAllUsersWithXNrQualifications(ArrayList<String> qualificationArray){
            return userQService.findAllUsersWithXNrQualifications(qualificationArray);
        }
}
