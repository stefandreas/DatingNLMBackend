package com.example.datingnlmbackend.User;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.datingnlmbackend.Qualification.Qualification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<User> saveUserWithQualifications(@RequestBody UserDTO userDTO) {
        User savedUser = userService.saveUserWithQualifications(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

@GetMapping("/findUserById")
    public User findUserById(Long id){
        return userService.findUserById(id);
}
@GetMapping("/findUserByFirstnameAndLastname")
    public User findUserByFirstnameAndLastname(String firstname, String lastname){
        return userService.findUserByFirstnameAndLastname(firstname,lastname);
}
@GetMapping("/findUserIdByEmail")
    public Long findUserIdByEmail(String email){
        return userService.findUserIdByEmail(email);
}
@GetMapping("/findUserByUsername")
    public User findUserByUsername(String username){
        return userService.findUserByUsername(username);
}

@GetMapping("/match")
    public int matchWithProfile(Long userId, Long visitedProfileId){
        return userService.matchWithProfile(userId,visitedProfileId);
}

@PostMapping(value = "/saveUser",consumes = "application/json")
    public Long save(@RequestBody User user ){
        return userService.save(user);
}
@PostMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
}
@DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }
}
