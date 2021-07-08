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
    //    @EmbeddedId
//    @NonNull
//    private ConversationReplyKey id;

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cr_id;
    @NonNull
    private String reply;
    @NonNull
    private Timestamp time;

    @JsonBackReference(value = "user-reply")
    @ManyToOne
    @JoinColumn(name = "user_id_fk", nullable = false)
    @NonNull
    private User user;

    @JsonIgnore
    @JsonBackReference(value = "conversation-reply")
    @ManyToOne
    @JoinColumn(name = "c_id_fk")
    @NonNull
    private Conversation conversation;

    public ConversationReply() {
    }

    public int getCr_id() {
        return cr_id;
    }

    public void setCr_id(int cr_id) {
        this.cr_id = cr_id;
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
