package sk.chatbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.User;

@Component
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {

    @Query(value =
            "SELECT COUNT(*) " +
            "FROM conversation " +
            "WHERE (user_one = ?1 AND user_two = ?2) " +
            "OR (user_one = ?2 AND user_two = ?1)",
            nativeQuery = true)
    @Transactional
    int haveUsersCreatedConversation(int userOneId, int userTwoId);
}
