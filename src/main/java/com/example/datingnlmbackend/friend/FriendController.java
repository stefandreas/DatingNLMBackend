package com.example.datingnlmbackend.friend;

import com.example.datingnlmbackend.User.User;
import com.example.datingnlmbackend.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/friend")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;
    private final UserService userService;

    @GetMapping("/getAllFriends/{userId}")
    private List<Friend> getFriends(@PathVariable long userId) {
        User user = new User();
        user = userService.findById(userId);
        return user.getFriends();
    }

}
