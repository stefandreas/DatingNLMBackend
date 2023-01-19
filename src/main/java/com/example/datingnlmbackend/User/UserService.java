package com.example.datingnlmbackend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //metod för login://
    /*@Override
    public User login(String username, String password) {
        User user = userRepository.checkUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
                return null;
            }

     */

    @Override
    public User login(String username, String password) {
        return null;
    }

    //metod för registrering://
    public User register(User registerUser) {
        ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(registerUser.getUsername())) {
                return null;
            }
            user = new User();
            user.setFirstname(registerUser.getFirstname());
            user.setLastname(registerUser.getLastname());
            user.setUsername(registerUser.getUsername());
            user.setEmail(registerUser.getEmail());
            user.setPassword(registerUser.getPassword());
            userRepository.save(registerUser);
        }
        return registerUser;
    }
}

    //metod som kollar om användaren är registrerad://
   /* public boolean ifUsernameExist(String username){
        User user = userRepository.getUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }

    */






