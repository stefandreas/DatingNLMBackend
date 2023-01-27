package com.example.datingnlmbackend.Qualification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification,Long> {
    Qualification findByQualification(String name);
}
