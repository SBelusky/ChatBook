package sk.chatbook.model.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.User;
import sk.chatbook.model.dto.ConversationDto;
import sk.chatbook.model.dto.ConversationReplyDto;
import sk.chatbook.model.dto.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-30T21:55:43+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.7 (JetBrains s.r.o.)"
)
@Component
public class ConversationReplyMapperImpl implements ConversationReplyMapper {

    @Override
    public ConversationReplyDto toConversationReplyDto(ConversationReply conversationReply) {
        if ( conversationReply == null ) {
            return null;
        }

        ConversationReplyDto conversationReplyDto = new ConversationReplyDto();

        conversationReplyDto.setUser( toUserDto( conversationReply.getUser() ) );
        conversationReplyDto.setReply( conversationReply.getReply() );
        conversationReplyDto.setTime( conversationReply.getTime() );

        return conversationReplyDto;
    }

    @Override
    public ConversationReply toConversationReply(ConversationReplyDto conversationReplyDto) {
        if ( conversationReplyDto == null ) {
            return null;
        }

        ConversationReply conversationReply = new ConversationReply();

        conversationReply.setUser( toUser( conversationReplyDto.getUser() ) );
        conversationReply.setConversation( conversationDtoToConversation( conversationReplyDto.getConversation() ) );
        conversationReply.setReply( conversationReplyDto.getReply() );
        conversationReply.setTime( conversationReplyDto.getTime() );

        return conversationReply;
    }

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUser_id( user.getUser_id() );
        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );

        return userDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUser_id( userDto.getUser_id() );
        user.setUsername( userDto.getUsername() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    protected Conversation conversationDtoToConversation(ConversationDto conversationDto) {
        if ( conversationDto == null ) {
            return null;
        }

        Conversation conversation = new Conversation();

        conversation.setC_id( conversationDto.getC_id() );
        conversation.setUser_one( toUser( conversationDto.getUser_one() ) );
        conversation.setUser_two( toUser( conversationDto.getUser_two() ) );

        return conversation;
    }
}
