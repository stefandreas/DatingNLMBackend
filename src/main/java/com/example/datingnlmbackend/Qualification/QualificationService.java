package com.example.datingnlmbackend.Qualification;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationService implements QualificationServiceInterface {

    private QualificationRepository qualificationRepository;
    private String[] qualifications = {"Datorkunskaper", "Kommunikation", "Problemlösning", "Tidshantering", "Överförbara kompetenser"};

    public QualificationService(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }

    @PostConstruct
    public void insertInitialQualifications() {
        for (String qualification : qualifications) {
            Optional<Qualification> existingQualification = Optional.ofNullable(qualificationRepository.findByQualification(qualification));
            if (!existingQualification.isPresent()) {
                qualificationRepository.save(new Qualification(qualification));
            }
        }
    }
    
    public List<Qualification> findAllQualification(){return qualificationRepository.findAll();}
}
