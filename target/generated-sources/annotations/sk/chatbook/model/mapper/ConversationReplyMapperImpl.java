package sk.chatbook.model.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.dto.ConversationReplyDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-24T12:08:22+0200",
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

        conversationReplyDto.setUser( conversationReply.getUser() );
        conversationReplyDto.setConversation( conversationReply.getConversation() );
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

        conversationReply.setUser( conversationReplyDto.getUser() );
        conversationReply.setConversation( conversationReplyDto.getConversation() );
        conversationReply.setReply( conversationReplyDto.getReply() );
        conversationReply.setTime( conversationReplyDto.getTime() );

        return conversationReply;
    }
}
