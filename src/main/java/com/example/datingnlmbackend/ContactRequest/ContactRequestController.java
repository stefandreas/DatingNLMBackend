package com.example.datingnlmbackend.ContactRequest;

//Presentation Layer/class

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact-requests")
@RequiredArgsConstructor
public class ContactRequestController {


    private final ContactRequestService contactRequestService;

    @PostMapping("/send")
    public ResponseEntity<String> sendContactRequest(@RequestBody ContactRequestDTO contactRequestDTO) {
        contactRequestService.sendContactRequest(contactRequestDTO.getSender(), contactRequestDTO.getRecipientId());
        return new ResponseEntity<>("Contact request sent successfully!", HttpStatus.OK);
    }

    @PutMapping("/accept/{id}")
    public ResponseEntity<String> acceptContactRequest(@PathVariable("id") long requestId, @RequestParam("accept") boolean isAccepted) {
        contactRequestService.acceptContactRequest(requestId, isAccepted);
        return new ResponseEntity<>("Contact request updated successfully!", HttpStatus.OK);
    }

}

