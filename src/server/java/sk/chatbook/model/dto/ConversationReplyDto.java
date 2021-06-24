package sk.chatbook.model.dto;

import sk.chatbook.model.Conversation;
import sk.chatbook.model.User;
import sk.chatbook.model.compositeKey.ConversationReplyKey;

import java.sql.Timestamp;

public class ConversationReplyDto {
    private ConversationReplyKey conversationReplyKey;
    private User user;
    private Conversation conversation;
    private String reply;
    private Timestamp time;

    public ConversationReplyDto() {
    }

    public ConversationReplyDto(ConversationReplyKey conversationReplyKey, User user, Conversation conversation, String reply, Timestamp time) {
        this.conversationReplyKey = conversationReplyKey;
        this.user = user;
        this.conversation = conversation;
        this.reply = reply;
        this.time = time;
    }

    public ConversationReplyKey getConversationReplyKey() {
        return conversationReplyKey;
    }

    public void setConversationReplyKey(ConversationReplyKey conversationReplyKey) {
        this.conversationReplyKey = conversationReplyKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
