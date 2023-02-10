package com.example.datingnlmbackend.ContactRequest;

import com.example.datingnlmbackend.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactRequestDTO {
    private Long id;

    private User sender;

    private Long recipientId;

    private String status;

    private boolean accepted;
}
