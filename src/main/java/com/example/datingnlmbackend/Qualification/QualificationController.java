package com.example.datingnlmbackend.Qualification;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/qualifications")
public class QualificationController {

    QualificationService qualificationService;

    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @PostMapping("/save")
    ResponseEntity<Qualification> save(String qualification) {
        return new ResponseEntity<>(qualificationService.save(qualification), HttpStatus.CREATED);
    }
}
