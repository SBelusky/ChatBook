package sk.chatbook.service;

import org.springframework.lang.Nullable;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.model.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Map;

public interface UserService {
    @Nullable
    UserDto getUserByEmail(String email);

    @Nullable
    User addUser(UserDto userDto) throws InvalidKeySpecException, NoSuchAlgorithmException;

    Map<String, String> validateUser(UserDto userDto);

    List<User> getAllUsersForUserDetails();
}
