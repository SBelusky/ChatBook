package sk.chatbook.model.dto;

import sk.chatbook.model.User;
import java.sql.Timestamp;

public class ConversationDto {
    private int c_id;
    private UserDto user_one;
    private UserDto user_two;
    private String lastMsg;
    private Integer userIdOfLastMsg;

    public ConversationDto() {
    }

    public ConversationDto(int c_id, UserDto user_one, UserDto user_two) {
        this.c_id = c_id;
        this.user_one = user_one;
        this.user_two = user_two;
    }

    public UserDto getUser_one() {
        return user_one;
    }

    public void setUser_one(UserDto user_one) {
        this.user_one = user_one;
    }

    public UserDto getUser_two() {
        return user_two;
    }

    public void setUser_two(UserDto user_two) {
        this.user_two = user_two;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public Integer getUserIdOfLastMsg() {
        return userIdOfLastMsg;
    }

    public void setUserIdOfLastMsg(Integer userIdOfLastMsg) {
        this.userIdOfLastMsg = userIdOfLastMsg;
    }
}
