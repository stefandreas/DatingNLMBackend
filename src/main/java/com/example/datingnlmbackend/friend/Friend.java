package com.example.datingnlmbackend.friend;

import com.example.datingnlmbackend.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_a_id")
    private User user;

    @JoinColumn(name = "user_b_id")
    private long friendId;
}
