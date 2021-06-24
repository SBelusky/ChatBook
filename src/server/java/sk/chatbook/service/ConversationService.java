package sk.chatbook.service;

import org.springframework.lang.Nullable;
import sk.chatbook.model.dto.ConversationDto;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.model.User;

public interface ConversationService {
    @Nullable
    UserDto getConversationById(int c_id);

    @Nullable
    UserDto getConversationByUsers(int user_one_id, int user_two_id);

    @Nullable
    User addConversation(ConversationDto conversationDto);
}
