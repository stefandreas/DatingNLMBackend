package com.example.datingnlmbackend.Qualification;

import org.springframework.stereotype.Service;

@Service
public class QualificationService implements QualificationServiceInterface {

    private QualificationRepository qualificationsRepository;
    private String[] qualifications = {"Math", "History", "Space", "Art"};

    public QualificationService(QualificationRepository qualificationsRepository) {
        this.qualificationsRepository = qualificationsRepository;
        for (String qualification: qualifications) {
            save(qualification);
        }
    }

    @Override
    public Qualification save(String qualification) {
        return qualificationsRepository.save(new Qualification(qualification));
    }
}
