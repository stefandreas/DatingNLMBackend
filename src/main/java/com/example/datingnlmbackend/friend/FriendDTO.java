package com.example.datingnlmbackend.friend;

import com.example.datingnlmbackend.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {

    private User user;

    private Long friendId;
}

