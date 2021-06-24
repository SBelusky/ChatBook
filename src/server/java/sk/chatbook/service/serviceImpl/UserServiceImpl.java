package sk.chatbook.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.model.User;
import sk.chatbook.model.mapper.UserMapper;
import sk.chatbook.repository.UserRepository;
import sk.chatbook.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User addUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);

        if (user.getUser_name() == null ||
                user.getEmail() == null ||
                user.getPassword() == null
        ){
            return null;
        }
        return userRepository.save(user);
    }
}
