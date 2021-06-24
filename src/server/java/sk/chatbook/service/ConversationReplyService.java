package sk.chatbook.service;

import org.springframework.lang.Nullable;
import sk.chatbook.model.User;
import sk.chatbook.model.dto.ConversationReplyDto;
import sk.chatbook.model.dto.UserDto;

public interface ConversationReplyService {
    @Nullable
    UserDto getConversationReplyes(int c_id);

    @Nullable
    User addConversationReplay(ConversationReplyDto conversationReplyDto);
}
