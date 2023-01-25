package com.example.datingnlmbackend.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
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
