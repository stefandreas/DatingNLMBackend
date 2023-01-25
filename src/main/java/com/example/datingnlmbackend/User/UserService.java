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
    public User findUserByFirstnameAndLastname(String firstname, String lastname){
        return userRepository.findUserByFirstnameAndLastname(firstname,lastname);
    }
    public void save(User user){
        userRepository.save(user);
    }
    public ResponseEntity<User> updateUser(User updatedUser){
        return new ResponseEntity<>(userRepository.save(updatedUser), HttpStatus.ACCEPTED);
    }
    public String deleteUser(User user){
        User userToDelete = findUserById(user.getId());
        userRepository.delete(userToDelete);
        return "User "+user.getFirstname()+" "+user.getLastname()+" was deleted!";
    }
}
