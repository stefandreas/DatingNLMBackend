package com.example.datingnlmbackend.Message;

import com.example.datingnlmbackend.Conversation.Conversation;
import com.example.datingnlmbackend.Conversation.ConversationRepository;
import com.example.datingnlmbackend.Conversation.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MessageController sends and receives messages (Websocket, Stomp)
 */

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private ConversationService conversationService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private ConversationRepository conversationRepository;

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ResponseEntity<Message> processMessage(@Payload Message message) {
        var id = conversationService.getConversationId(message.getSender(), message.getReceiver(), true);
        Conversation conversation = conversationRepository.findById(id.get()).orElseThrow(()-> new RuntimeException("Conversation not found"));
        message.setConversation(conversation);

        log.info("Saving message: {}", message);
        messageService.save(message);

        log.info("Sending message to user: {}", message.getReceiver());
        simpMessagingTemplate.convertAndSendToUser(message.getReceiver().toString(), "/topic/messages", message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
