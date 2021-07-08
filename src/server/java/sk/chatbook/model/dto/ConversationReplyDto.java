package sk.chatbook.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.User;
import sk.chatbook.model.compositeKey.ConversationReplyKey;

import java.sql.Timestamp;

public class ConversationReplyDto {
    private ConversationReplyKey conversationReplyKey;
    private UserDto user;
    private ConversationDto conversation;
    private String reply;
    private Timestamp time;

    public ConversationReplyDto() {
    }

    public ConversationReplyDto(ConversationReplyKey conversationReplyKey, UserDto user, ConversationDto conversation, String reply, Timestamp time) {
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public ConversationDto getConversation() {
        return conversation;
    }

    public void setConversation(ConversationDto conversation) {
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
