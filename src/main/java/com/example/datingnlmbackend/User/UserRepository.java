package com.example.datingnlmbackend.User;

import com.example.datingnlmbackend.Qualification.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //boolean existsUserByUsername(String username);
    //boolean existsUserByEmail(String email);

    User findUserById(Long id);
    User findUserByFirstnameAndLastname(String firstname, String lastname);
}
