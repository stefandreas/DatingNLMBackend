package com.example.datingnlmbackend.Conversation;

import com.example.datingnlmbackend.User.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class ConversationService implements ConversationServiceInterface {

    private ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }


    @Override
    public Optional<String> getConversationId(User user1, User user2, boolean createIfNotExists) {
        return conversationRepository.findByUser1AndUser2(user1, user2)
                .map(Conversation::getId)
                .or(()-> {
                    if(!createIfNotExists) {
                        return Optional.empty();
                    }
                    String id = String.format(String.valueOf(UUID.randomUUID()));

                    Conversation conversation = Conversation
                            .builder()
                            .id(id)
                            .user1(user1)
                            .user2(user2)
                            .build();
                    conversationRepository.save(conversation);

                    System.out.println(conversation.getId());

                    return Optional.of(id);
                });
    }

    @Override
    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }
}
