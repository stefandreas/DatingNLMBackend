package com.example.datingnlmbackend.User;

import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(Long id){
        Optional<User>user = repository.findById(id);
        if (user.isEmpty()){
            throw new NoResultException("User not found");
        }
        return user.get();
    }

}






