package sk.chatbook.model.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.dto.ConversationDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-24T12:08:22+0200",
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

        conversationDto.setC_id( conversation.getC_id() );
        conversationDto.setUser_one( conversation.getUser_one() );
        conversationDto.setUser_two( conversation.getUser_two() );
        conversationDto.setTime( conversation.getTime() );

        return conversationDto;
    }

    @Override
    public Conversation toConversation(ConversationDto conversationDto) {
        if ( conversationDto == null ) {
            return null;
        }

        Conversation conversation = new Conversation();

        conversation.setC_id( conversationDto.getC_id() );
        conversation.setUser_one( conversationDto.getUser_one() );
        conversation.setUser_two( conversationDto.getUser_two() );
        conversation.setTime( conversationDto.getTime() );

        return conversation;
    }
}
