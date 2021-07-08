package sk.chatbook.auth;

import java.util.Optional;

public interface ApplicationUserDAO {

    Optional<ApplicationUser> selectApplicationUserByEmail(String email);
}
