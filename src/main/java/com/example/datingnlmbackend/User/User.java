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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String gender;
    private String city;
    private String description;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_qualification",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "qualification_id"))
    private List<Qualification> qualifications;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_preferred_qualification",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "qualification_id"))
    private List<Qualification> preferredQualifications;


    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public List<Qualification> getPreferredQualifications() {
        return preferredQualifications;
    }

    public void setPreferredQualifications(List<Qualification> preferredQualifications) {
        this.preferredQualifications = preferredQualifications;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ContactRequest> contactRequestList;
    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Friend>friends;

}
