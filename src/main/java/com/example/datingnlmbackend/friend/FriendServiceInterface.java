package com.example.datingnlmbackend.friend;

import com.example.datingnlmbackend.User.User;

import java.util.List;

public interface FriendServiceInterface {

    void addFriend(User user1, User user2);

    boolean existsByUserAndFriendId(User user, long friendId);

    List<Friend>getFriends(User user);

}
