package sk.chatbook.model.compositeKey;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConversationReplyKey implements Serializable {
    @Column(name = "cr_id")
    private Integer cr_id;

    @Column(name = "user_id_fk")
    private Integer user_id_fk;

    public ConversationReplyKey() {
    }

    public ConversationReplyKey(Integer cr_id, Integer user_id_fk) {
        this.cr_id = cr_id;
        this.user_id_fk = user_id_fk;
    }

    public Integer getCr_id() {
        return cr_id;
    }

    public void setCr_id(Integer cr_id) {
        this.cr_id = cr_id;
    }

    public Integer getUser_id_fk() {
        return user_id_fk;
    }

    public void setUser_id_fk(Integer user_id_fk) {
        this.user_id_fk = user_id_fk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationReplyKey that = (ConversationReplyKey) o;
        return Objects.equals(cr_id, that.cr_id) &&
                Objects.equals(user_id_fk, that.user_id_fk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cr_id, user_id_fk);
    }
}
