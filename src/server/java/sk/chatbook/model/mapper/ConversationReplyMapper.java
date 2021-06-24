package sk.chatbook.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.dto.ConversationReplyDto;

@Mapper
public interface ConversationReplyMapper {
    ConversationReplyMapper INSTACE = Mappers.getMapper(ConversationReplyMapper.class);

    ConversationReplyDto toConversationReplyDto(ConversationReply conversationReply);

    ConversationReply toConversationReply(ConversationReplyDto conversationReplyDto);
}
