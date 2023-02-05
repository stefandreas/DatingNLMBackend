package com.example.datingnlmbackend.User;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;


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
    User findUserById(Long userId){
        return userService.findUserById(userId);
}
@GetMapping("/findUserByFirstnameAndLastname")
    User findUserByFirstnameAndLastname(String firstname, String lastname){
        return userService.findUserByFirstnameAndLastname(firstname,lastname);
}
@PostMapping("/saveUser")
    void save(@RequestBody User user){
        userService.save(user);
}
@PostMapping("/updateUser")
    ResponseEntity<User>updateUser(@RequestBody User user){
        return userService.updateUser(user);
}
@DeleteMapping("/deleteUser")
    String deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

}
