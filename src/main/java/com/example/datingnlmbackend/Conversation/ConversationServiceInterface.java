package com.example.datingnlmbackend.Conversation;

import com.example.datingnlmbackend.User.User;

import java.util.List;
import java.util.Optional;

public interface ConversationServiceInterface {
    Optional<String> getConversationId(User user1, User user2, boolean createIfNotExists);

    List<Conversation> getAllConversations();
}
