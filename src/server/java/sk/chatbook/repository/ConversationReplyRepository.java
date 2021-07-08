package sk.chatbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.compositeKey.ConversationReplyKey;

@Component
public interface ConversationReplyRepository extends JpaRepository<ConversationReply,ConversationReplyKey>{

    @Query(value =
            "SELECT reply " +
            "FROM conversation_reply " +
            "WHERE c_id_fk = ?1 " +
            "ORDER BY time DESC " +
            "LIMIT 1;",
            nativeQuery = true)
    @Transactional
    String lastMessageOfConversation(int c_id);

    @Query(value =
            "SELECT user_id_fk " +
            "FROM conversation_reply " +
            "WHERE c_id_fk = ?1 " +
            "ORDER BY time DESC " +
            "LIMIT 1;",
            nativeQuery = true)
    @Transactional
    Integer userIdOflastMessage(int c_id);
}
