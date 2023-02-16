package com.example.datingnlmbackend.Conversation;

import com.example.datingnlmbackend.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, String> {

    Optional<Conversation> findByUser1AndUser2(User user1, User user2);

    List<Conversation> findAll();
}
