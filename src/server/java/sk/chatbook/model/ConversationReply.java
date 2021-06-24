package sk.chatbook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;
import sk.chatbook.model.compositeKey.ConversationReplyKey;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "conversation_reply")
public class ConversationReply {
    @EmbeddedId
    @NonNull
    private ConversationReplyKey id;
    @NonNull
    private String reply;
    @NonNull
    private Timestamp time;

    @JsonBackReference(value = "user-reply")
    @ManyToOne
    @JoinColumn(name="user_id_fk", nullable=false)
    @MapsId("user_id_fk")
    @NonNull
    private User user;

    @JsonIgnore
    @JsonBackReference(value = "conversation-reply")
    @ManyToOne
    @JoinColumn(name="c_id_fk")
    @MapsId("c_id_fk")
    @NonNull
    private Conversation conversation;

    public ConversationReply() {
    }

    @NonNull
    public ConversationReplyKey getId() {
        return id;
    }

    public void setId(@NonNull ConversationReplyKey id) {
        this.id = id;
    }

    @NonNull
    public User getUser() {
        return user;
    }

    public void setUser(@NonNull User user) {
        this.user = user;
    }

    @NonNull
    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(@NonNull Conversation conversation) {
        this.conversation = conversation;
    }

    @NonNull
    public String getReply() {
        return reply;
    }

    public void setReply(@NonNull String reply) {
        this.reply = reply;
    }

    @NonNull
    public Timestamp getTime() {
        return time;
    }

    public void setTime(@NonNull Timestamp time) {
        this.time = time;
    }

}
