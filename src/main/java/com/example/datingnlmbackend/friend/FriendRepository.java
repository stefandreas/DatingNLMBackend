package com.example.datingnlmbackend.friend;

import com.example.datingnlmbackend.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

    boolean existsByUserAndFriendId(User user, long friendId);

    List<Friend> getFriendsByUser(User user);

}
