package com.example.datingnlmbackend;
import com.example.datingnlmbackend.Conversation.Conversation;
import com.example.datingnlmbackend.Conversation.ConversationRepository;
import com.example.datingnlmbackend.Conversation.ConversationService;
import com.example.datingnlmbackend.Message.Message;
import com.example.datingnlmbackend.Message.MessageController;
import com.example.datingnlmbackend.Message.MessageService;
import com.example.datingnlmbackend.User.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    @Mock
    private ConversationService conversationService;

    @Mock
    private ConversationRepository conversationRepository;

    @Mock
    private MessageService messageService;

    @Mock
    private SimpMessagingTemplate simpMessagingTemplate;

    @InjectMocks
    private MessageController messageController;

    public MessageControllerTest(){

    }

    @Test
    public void testProcessMessage() {
        User user1 = new User();
        user1.setId(1L);
        User user2 = new User();
        user2.setId(2L);
        Message message = new Message();
        message.setSender(user1);
        message.setReceiver(user2);

        when(conversationService.getConversationId(any(User.class), any(User.class), any(Boolean.class)))
                .thenReturn(Optional.of("69f6c0e4-f97e-4fba-bb47-2af377a073de"));
        when(conversationRepository.findById(any(String.class)))
                .thenReturn(Optional.of(new Conversation()));
        when(messageService.save(any(Message.class)))
                .thenReturn(message);

        ResponseEntity<Message> response = messageController.processMessage(message);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(message, response.getBody());
    }
}
