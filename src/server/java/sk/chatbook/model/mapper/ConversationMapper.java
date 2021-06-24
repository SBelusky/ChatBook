package sk.chatbook.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.dto.ConversationDto;

@Mapper
public interface ConversationMapper {
    ConversationMapper INSTACE = Mappers.getMapper(ConversationMapper.class);

    ConversationDto toConversationDto(Conversation conversation);

    Conversation toConversation(ConversationDto conversationDto);
}
