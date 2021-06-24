package sk.chatbook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;

    @JsonBackReference(value = "user-conversation_one")
    @ManyToOne
    @MapsId("user_one")
    @JoinColumn(name = "user_one")
    @NonNull
    private User user_one;

    @JsonBackReference(value = "user-conversation_two")
    @ManyToOne
    @MapsId("user_two")
    @JoinColumn(name = "user_two")
    @NonNull
    private User user_two;

    @NonNull
    private Timestamp time;

    @JsonManagedReference(value = "conversation-reply")
    @OneToMany(mappedBy="conversation")
    @Nullable
    private Set<ConversationReply> reply;

    public Conversation() {
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    @NonNull
    public User getUser_one() {
        return user_one;
    }

    public void setUser_one(@NonNull User user_one) {
        this.user_one = user_one;
    }

    @NonNull
    public User getUser_two() {
        return user_two;
    }

    public void setUser_two(@NonNull User user_two) {
        this.user_two = user_two;
    }

    @NonNull
    public Timestamp getTime() {
        return time;
    }

    public void setTime(@NonNull Timestamp time) {
        this.time = time;
    }

    @Nullable
    public Set<ConversationReply> getReply() {
        return reply;
    }

    public void setReply(@Nullable Set<ConversationReply> reply) {
        this.reply = reply;
    }
}
