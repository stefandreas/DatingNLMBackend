package com.example.datingnlmbackend.Conversation;

import com.example.datingnlmbackend.Message.Message;
import com.example.datingnlmbackend.User.User;

import java.util.List;

public class ConversationDTO {
    private Long id;

    private User user1;

    private User user2;

    private List<Message> messages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "ConversationDTO{" +
                "id=" + id +
                ", user1=" + user1 +
                ", user2=" + user2 +
                ", messages=" + messages +
                '}';
    }
}
