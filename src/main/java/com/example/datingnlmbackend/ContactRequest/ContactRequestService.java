package com.example.datingnlmbackend.ContactRequest;


import com.example.datingnlmbackend.User.User;
import com.example.datingnlmbackend.User.UserService;
import com.example.datingnlmbackend.friend.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactRequestService implements ContactRequestServiceInterface{
    private final ContactRequestRepository repository;
    private final UserService userService;
    private final FriendService friendService;

    @Override
    public void sendContactRequest(User sender, long recipientId) {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setSender(sender);
        contactRequest.setRecipientId(recipientId);
        contactRequest.setStatus("Pending");
        repository.save(contactRequest);
    }

    @Override
    public void acceptContactRequest(long requestId, boolean isAccepted) {
        Optional<ContactRequest> request = repository.findById(requestId);
        if (request.isPresent()){
            ContactRequest contactRequest = request.get();

            if (isAccepted){
                request.get().setStatus("ACCEPTED");
                User user1 = contactRequest.getSender();
                User user2 = userService.findById(contactRequest.getRecipientId());

                friendService.addFriend(user1, user2);
            }else{
                request.get().setStatus("DECLINED");
            }
            repository.save(contactRequest);
        }
    }
}
