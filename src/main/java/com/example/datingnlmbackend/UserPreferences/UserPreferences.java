package com.example.datingnlmbackend.UserPreferences;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class UserPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String p1;
    String p2;
    String p3;
    String p4;
    String p5;
    @Column(unique = true)
    Long userId;

    public UserPreferences(String p1, String p2, String p3, String p4, String p5, Long userId) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.userId = userId;
    }

    public UserPreferences() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }
    public List<String> getAllPreferences(){
        List<String> listPreferences = new ArrayList<>();
        listPreferences.add(p1);
        listPreferences.add(p2);
        listPreferences.add(p3);
        listPreferences.add(p4);
        listPreferences.add(p5);
        return listPreferences;
    }
}
