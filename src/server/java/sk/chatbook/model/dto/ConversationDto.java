package sk.chatbook.model.dto;

import sk.chatbook.model.User;
import java.sql.Timestamp;

public class ConversationDto {
    private int c_id;
    private User user_one;
    private User user_two;
    private Timestamp time;

    public ConversationDto() {
    }

    public ConversationDto(int c_id, User user_one, User user_two, Timestamp time) {
        this.c_id = c_id;
        this.user_one = user_one;
        this.user_two = user_two;
        this.time = time;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public User getUser_one() {
        return user_one;
    }

    public void setUser_one(User user_one) {
        this.user_one = user_one;
    }

    public User getUser_two() {
        return user_two;
    }

    public void setUser_two(User user_two) {
        this.user_two = user_two;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
