package com.example.datingnlmbackend.User;

import org.springframework.stereotype.Service;

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
    public User register(String firstname, String lastname, String username, String email, String password) {
        if(userRepository.existsByUsernameAndEmail(username, email)){
            return null;
        }
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);
        return user;
    }
}






