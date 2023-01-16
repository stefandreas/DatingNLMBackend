package com.example.datingnlmbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("User")
public class DatingNlmBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatingNlmBackendApplication.class, args);
    }

}
