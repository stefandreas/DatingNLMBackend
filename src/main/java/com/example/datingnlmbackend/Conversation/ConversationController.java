package com.example.datingnlmbackend.Conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;


    @GetMapping("/conversation")
    public ResponseEntity<Conversation> getConversationId(@RequestBody Conversation conversation){
        conversationService.getConversationId(conversation.getUser1(), conversation.getUser2(), false);
        return new ResponseEntity<>(conversation, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Conversation> saveConversation(@RequestBody Conversation conversation){
        conversationService.getConversationId(conversation.getUser1(), conversation.getUser2(), true);
        return new ResponseEntity<>(conversation, HttpStatus.OK);
    }

    @GetMapping("/getAllConversations")
    public ResponseEntity<List<Conversation>> getAllConversations(){
        List<Conversation> conversations = conversationService.getAllConversations();
        return new ResponseEntity<>(conversations, HttpStatus.OK);
    }

}
