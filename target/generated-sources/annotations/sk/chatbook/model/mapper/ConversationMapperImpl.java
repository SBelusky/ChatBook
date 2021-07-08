package sk.chatbook.model.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.User;
import sk.chatbook.model.dto.ConversationDto;
import sk.chatbook.model.dto.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-30T21:55:43+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.7 (JetBrains s.r.o.)"
)
@Component
public class ConversationMapperImpl implements ConversationMapper {

    @Override
    public ConversationDto toConversationDto(Conversation conversation) {
        if ( conversation == null ) {
            return null;
        }

        ConversationDto conversationDto = new ConversationDto();

        conversationDto.setUser_one( toUserDto( conversation.getUser_one() ) );
        conversationDto.setUser_two( toUserDto( conversation.getUser_two() ) );
        conversationDto.setC_id( conversation.getC_id() );

        return conversationDto;
    }

    @Override
    public Conversation toConversation(ConversationDto conversationDto) {
        if ( conversationDto == null ) {
            return null;
        }

        Conversation conversation = new Conversation();

        conversation.setC_id( conversationDto.getC_id() );
        conversation.setUser_one( toUser( conversationDto.getUser_one() ) );
        conversation.setUser_two( toUser( conversationDto.getUser_two() ) );

        return conversation;
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
}
