package com.example.datingnlmbackend.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long userId){
       return userRepository.findUserById(userId);
    }
    public ResponseEntity<User> updateUser(User user){
        User updated = userRepository.findUserById(user.getId());
        updated = user;
        return new ResponseEntity<>(userRepository.save(updated), HttpStatus.ACCEPTED);
    }
}
