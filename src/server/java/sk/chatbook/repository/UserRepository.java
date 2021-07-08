package sk.chatbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.chatbook.model.User;

@Component
public interface UserRepository extends JpaRepository<User,Integer>{

    @Query(value =
            "SELECT * " +
            "FROM users " +
            "WHERE email = ?1 " +
            "LIMIT 1",
            nativeQuery = true)
    @Transactional
    User findUserByEmail(String email);
}
