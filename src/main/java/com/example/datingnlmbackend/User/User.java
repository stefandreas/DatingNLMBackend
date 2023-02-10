package com.example.datingnlmbackend.User;

import com.example.datingnlmbackend.ContactRequest.ContactRequest;
import com.example.datingnlmbackend.friend.Friend;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Column (unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ContactRequest> contactRequestList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Friend>friends;

}
