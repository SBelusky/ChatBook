package sk.chatbook.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.User;
import sk.chatbook.model.dto.ConversationDto;
import sk.chatbook.model.dto.UserDto;

@Mapper
public interface ConversationMapper {
    ConversationMapper INSTACE = Mappers.getMapper(ConversationMapper.class);

    ConversationDto toConversationDto(Conversation conversation);

    Conversation toConversation(ConversationDto conversationDto);

    // ****
    // for user_one and user_two
    // ****
    @Mappings({
            @Mapping(target = "password", ignore=true),
    })
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
