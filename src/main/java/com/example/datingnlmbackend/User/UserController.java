package com.example.datingnlmbackend.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
@PostMapping("/updateUser")
    ResponseEntity<User>updateUser(@RequestBody User user){
        return userService.updateUser(user);
}

}
