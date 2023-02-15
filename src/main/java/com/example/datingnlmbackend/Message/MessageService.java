package com.example.datingnlmbackend.Message;


import com.example.datingnlmbackend.Message.Message;
import com.example.datingnlmbackend.Message.MessageRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements MessageServiceInterface {

    private SimpMessagingTemplate simpMessagingTemplate;
    private MessageRepository repository;
    private MessageService(SimpMessagingTemplate simpMessagingTemplate, MessageRepository repository) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.repository = repository;
    }
    // Spara meddelande i databasen
    public Message save(Message message){
        repository.save(message);
        return message;
    }

}
