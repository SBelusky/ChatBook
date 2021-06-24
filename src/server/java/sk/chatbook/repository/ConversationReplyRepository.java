package sk.chatbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.compositeKey.ConversationReplyKey;

@Component
public interface ConversationReplyRepository extends JpaRepository<ConversationReply,ConversationReplyKey>{
}
