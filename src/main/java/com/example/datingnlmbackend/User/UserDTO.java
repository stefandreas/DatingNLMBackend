package com.example.datingnlmbackend.User;

import jakarta.persistence.Column;

import java.util.List;

public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;

    private String email;
    private String password;
    private String gender;
    private String city;
    private String description;
    private List<String> qualifications;
    private List<String> preferredQualifications;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public UserDTO(){}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }

    public List<String> getPreferredQualifications() {
        return preferredQualifications;
    }

    public void setPreferredQualifications(List<String> preferredQualifications) {
        this.preferredQualifications = preferredQualifications;
    }
}
