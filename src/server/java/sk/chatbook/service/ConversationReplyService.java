package sk.chatbook.service;

import java.util.Map;
import org.springframework.lang.Nullable;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.dto.ConversationReplyDto;

import java.util.List;

public interface ConversationReplyService {
    @Nullable
    List<ConversationReplyDto> getConversationRepliesByConversationId(int c_id);

    @Nullable
    ConversationReply addConversationReplay(int conversationId, ConversationReplyDto conversationReplyDto);

    @Nullable
    Map<String, String> validateConversationReply(ConversationReplyDto conversationReplyDto);

}
