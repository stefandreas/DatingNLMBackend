package com.example.datingnlmbackend.Qualification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/qualification")
public class QualificationController {

    QualificationService qualificationService;

    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }
    
    @GetMapping ("/findAllQualification")
    public List<Qualification> findAllQualifications(){
        return qualificationService.findAllQualification();
    }
}
