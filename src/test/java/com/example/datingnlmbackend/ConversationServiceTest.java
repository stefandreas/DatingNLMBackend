package com.example.datingnlmbackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.datingnlmbackend.Conversation.Conversation;
import com.example.datingnlmbackend.Conversation.ConversationRepository;
import com.example.datingnlmbackend.Conversation.ConversationService;
import com.example.datingnlmbackend.User.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class ConversationServiceTest {

    private ConversationRepository conversationRepository;
    private ConversationService conversationService;

    @Before
    public void setUp() {
        conversationRepository = Mockito.mock(ConversationRepository.class);
        conversationService = new ConversationService(conversationRepository);
    }

    @Test
    public void testGetConversationId_existingConversation() {
        User user1 = new User();
        User user2 = new User();

        Conversation conversation = new Conversation();
        conversation.setId("1");
        conversation.setUser1(user1);
        conversation.setUser2(user2);

        Mockito.when(conversationRepository.findByUser1AndUser2(user1, user2)).thenReturn(Optional.of(conversation));

        Optional<String> conversationId = conversationService.getConversationId(user1, user2, false);

        assertTrue(conversationId.isPresent());
        assertEquals(1L, conversationId.get());
    }

    @Test
    public void testGetConversationId_notExistingConversation_notCreate() {
        User user1 = new User();
        User user2 = new User();

        Mockito.when(conversationRepository.findByUser1AndUser2(user1, user2)).thenReturn(Optional.empty());

        Optional<String> conversationId = conversationService.getConversationId(user1, user2, false);

        assertFalse(conversationId.isPresent());
    }

    @Test
    public void testGetConversationId_notExistingConversation_create() {
        User user1 = new User();
        user1.setId(1L);
        User user2 = new User();
        user2.setId(2L);

        Conversation conversation = new Conversation();
        conversation.setUser1(user1);
        conversation.setUser2(user2);

        Mockito.when(conversationRepository.findByUser1AndUser2(user1, user2)).thenReturn(Optional.empty());
        Mockito.when(conversationRepository.save(Mockito.any(Conversation.class))).thenReturn(conversation);

        Optional<String> conversationId = conversationService.getConversationId(user1, user2, true);

        assertTrue(conversationId.isPresent());
       // assertEquals(1L, conversationId.get());

    }
}
