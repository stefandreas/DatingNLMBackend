package com.example.datingnlmbackend.ContactRequest;

import com.example.datingnlmbackend.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "contact_requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @Column(name = "recipient_id")
    private Long recipientId;

    @Column(name = "status", nullable = false)
    private String status;

    private boolean accepted;
}
