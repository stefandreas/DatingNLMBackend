package com.example.datingnlmbackend.ContactRequest;

import com.example.datingnlmbackend.User.User;

public interface ContactRequestServiceInterface {
    void sendContactRequest(User sender, long recipientId);

    void acceptContactRequest(long id, boolean isAccepted);
}
