package sk.chatbook.service;

import org.springframework.lang.Nullable;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.dto.ConversationDto;

import java.util.List;
import java.util.Map;

public interface ConversationService {
    @Nullable
    ConversationDto getConversationById(int c_id);

    @Nullable
    List<ConversationDto> getConversationsByUser(int user_id);

    @Nullable
    Conversation addConversation(ConversationDto conversationDto);

    @Nullable
    Map<String, String> validateConversation(ConversationDto conversationDto);

    @Nullable
    List<ConversationDto> showOnlyOneUserInConversations(int loggedUserId, List<ConversationDto> conversationDtoList);
}
