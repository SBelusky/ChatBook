package sk.chatbook.service;

import org.springframework.lang.Nullable;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.model.User;

public interface UserService {
    @Nullable
    UserDto getUserByEmail(String email);

    @Nullable
    User addUser(UserDto userDto);
}
