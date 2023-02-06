package com.example.datingnlmbackend.Qualification;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QualificationService implements QualificationServiceInterface {

    private QualificationRepository qualificationsRepository;
    private String[] qualifications = {"Math", "History", "Space", "Art", "Astrology"};

    public QualificationService(QualificationRepository qualificationsRepository) {
        this.qualificationsRepository = qualificationsRepository;
    }

    @PostConstruct
    public void insertInitialQualifications() {
        for (String qualification : qualifications) {
            Optional<Qualification> existingQualification = Optional.ofNullable(qualificationsRepository.findByQualification(qualification));
            if (!existingQualification.isPresent()) {
                qualificationsRepository.save(new Qualification(qualification));
            }
        }
    }
}
