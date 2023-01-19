package com.example.datingnlmbackend.User;

import java.util.Map;
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

    @PostMapping("/save")
    public ResponseEntity<String> register(@RequestBody Map<String, String> body) {
        User user = userService.register(body.get("firstname"), body.get("lastname"),
                body.get("username"), body.get("email"), body.get("password"));

        if(user == null) {
            return new ResponseEntity<>("Error!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("User have been succesfully created!", HttpStatus.CREATED);
    }
}

