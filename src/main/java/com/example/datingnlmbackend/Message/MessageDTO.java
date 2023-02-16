package com.example.datingnlmbackend.Message;

import com.example.datingnlmbackend.Conversation.Conversation;
import com.example.datingnlmbackend.User.User;

public class MessageDTO {
    private Long id;

    private String messageContent;

    private User sender;

    private Conversation conversation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", messageContent='" + messageContent + '\'' +
                ", sender=" + sender +
                ", conversation=" + conversation +
                '}';
    }
}
