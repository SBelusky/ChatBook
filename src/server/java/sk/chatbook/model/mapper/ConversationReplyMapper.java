package sk.chatbook.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.User;
import sk.chatbook.model.dto.ConversationReplyDto;
import sk.chatbook.model.dto.UserDto;

@Mapper
public interface ConversationReplyMapper {
    ConversationReplyMapper INSTACE = Mappers.getMapper(ConversationReplyMapper.class);

    @Mappings({
            @Mapping(target = "conversation", ignore = true),
    })
    ConversationReplyDto toConversationReplyDto(ConversationReply conversationReply);

    ConversationReply toConversationReply(ConversationReplyDto conversationReplyDto);

    // ****
    // for user
    // ****
    @Mappings({
            @Mapping(target = "password", ignore = true),
    })
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
