package com.example.datingnlmbackend.Subject;

import org.springframework.stereotype.Service;

@Service
public class SubjectService implements SubjectServiceInterface{

    private SubjectRepository subjectRepository;
    private String[] subjects = {"Math", "History", "Space", "Art"};

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
        for (String subject: subjects) {
            save(subject);
        }
    }

    @Override
    public Subject save(String subject) {
        return subjectRepository.save(new Subject(subject));
    }
}
