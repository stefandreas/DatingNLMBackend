package com.example.datingnlmbackend.UserQualifications;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class UserQualifications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String q1;
    String q2;
    String q3;
    String q4;
    String q5;
    @Column(unique = true)
    Long userId;

    public UserQualifications(String q1, String q2, String q3, String q4, String q5, Long userId) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.userId = userId;
    }

    public UserQualifications() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }
    public List<String> getAllQualifications(){
        List<String> listQualifications = new ArrayList<>();
        listQualifications.add(q1);
        listQualifications.add(q2);
        listQualifications.add(q3);
        listQualifications.add(q4);
        listQualifications.add(q5);
        return listQualifications;
    }

}
