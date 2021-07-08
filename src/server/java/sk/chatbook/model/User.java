package sk.chatbook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;

    @JsonIgnore
    @JsonManagedReference(value = "user-conversation_one")
    @OneToMany(mappedBy="user_one")
    @Nullable
    private Set<Conversation> coonversation_one;

    @JsonIgnore
    @JsonManagedReference(value = "user-conversation_two")
    @OneToMany(mappedBy="user_two")
    @Nullable
    private Set<Conversation> conversation_two;

    @JsonIgnore
    @JsonManagedReference(value = "user-reply")
    @OneToMany(mappedBy="user")
    private Set<ConversationReply> replies;

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String user_name) {
        this.username = user_name;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @Nullable
    public Set<ConversationReply> getReplies() {
        return replies;
    }

    public void setReplies(@Nullable Set<ConversationReply> replies) {
        this.replies = replies;
    }

    @Nullable
    public Set<Conversation> getCoonversation_one() {
        return coonversation_one;
    }

    public void setCoonversation_one(@Nullable Set<Conversation> coonversation_one) {
        this.coonversation_one = coonversation_one;
    }

    @Nullable
    public Set<Conversation> getConversation_two() {
        return conversation_two;
    }

    public void setConversation_two(@Nullable Set<Conversation> conversation_two) {
        this.conversation_two = conversation_two;
    }
}
