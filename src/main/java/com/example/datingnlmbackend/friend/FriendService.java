package com.example.datingnlmbackend.friend;

import com.example.datingnlmbackend.User.User;
import com.example.datingnlmbackend.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FriendService implements FriendServiceInterface {

    private final FriendRepository repository;
    private final UserRepository userRepository;



    //metod för att lägga till en person
    @Override
    public void addFriend(User user1, User user2) {
            Friend friend1 = new Friend();
            friend1.setUser(user1);
            friend1.setFriendId(user2.getId());

            Friend friend2 = new Friend();
            friend2.setUser(user2);
            friend2.setFriendId(user1.getId());

            repository.saveAll(List.of(friend1, friend2));
    }

    //Kollar ifall kontakten finns mellan två personer i databasen
    @Override
    public boolean existsByUserAndFriendId(User user, long friendId) {
        return repository.existsByUserAndFriendId(user, friendId);
    }


    //metod för att hämta kontakter
    @Override
    public List<Friend> getFriends(User user) {
       return repository.getFriendsByUser(user);
    }
}



