package com.example.datingnlmbackend.Qualification;

import java.util.List;

public interface QualificationServiceInterface {
     void insertInitialQualifications();
     
     List<Qualification> findAllQualification();
}
