package com.example.datingnlmbackend.ContactRequest;

//Data Access layer/class

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {

}
