package com.example.datingnlmbackend.User;

import com.example.datingnlmbackend.Qualification.Qualification;
import com.example.datingnlmbackend.UserQualifications.UserQualifications;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String description;
    @Column(unique = true)
    private String email;
    private String firstname;
    private String gender;
    private String lastname;
    @Column(unique = true)
    private String username;
    
    public User(Long id, String city, String description, String email, String firstname, String gender,
                String lastname, String username) {
        this.id = id;
        this.city = city;
        this.description = description;
        this.email = email;
        this.firstname = firstname;
        this.gender = gender;
        this.lastname = lastname;
        this.username = username;
    }

    public User(String city, String description, String email, String firstname, String gender, String lastname, String username) {
        this.city = city;
        this.description = description;
        this.email = email;
        this.firstname = firstname;
        this.gender = gender;
        this.lastname = lastname;
        this.username = username;
    }

    public User() {
    }
    public void update(User user){
        this.id = user.id;
        this.city = user.city;
        this.description = user.description;
        this.email = user.email;
        this.firstname = user.firstname;
        this.gender = user.gender;
        this.lastname = user.lastname;
        this.username = user.username;
    }

    /*
            @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(name = "user_qualification",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "qualification_id"))
            private List<Qualification> qualifications;

            public List<Qualification> getQualifications() {
                return qualifications;
            }

            public void setQualifications(List<Qualification> qualifications) {
                this.qualifications = qualifications;
            }
         */
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
