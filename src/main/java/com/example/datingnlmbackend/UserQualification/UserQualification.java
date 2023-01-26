package com.example.datingnlmbackend.UserQualification;

import com.example.datingnlmbackend.Qualification.Qualification;
import com.example.datingnlmbackend.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "USER_QUALIFICATION")
public class UserQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("user_id")
    private User user;

    @ManyToOne
    @MapsId("qualification_id")
    private Qualification qualification;

    public UserQualification() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }
}
