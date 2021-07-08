package sk.chatbook.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import sk.chatbook.security.ApplicationUserRole;
import sk.chatbook.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("fake")
public class FakeApplicationUserDAOService implements ApplicationUserDAO {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public FakeApplicationUserDAOService(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByEmail(String email) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> email.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers =
                userService.getAllUsersForUserDetails()
                .stream()
                .map(user -> {
                    ApplicationUser applicationUser = new ApplicationUser(
                            ApplicationUserRole.valueOf("ADMIN").getGrantedAuthorities(),
                            user.getPassword(),
                            user.getEmail(),
                            true,
                            true,
                            true,
                            true
                    );
                    return applicationUser;
                })
                .collect(Collectors.toList());

        return applicationUsers;
    }
}
