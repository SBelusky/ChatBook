package sk.chatbook.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.model.User;
import sk.chatbook.model.mapper.UserMapper;
import sk.chatbook.repository.UserRepository;
import sk.chatbook.service.UserService;
import sk.chatbook.utility.PBKDF2;
import sk.chatbook.utility.ValidationHelpers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public UserDto getUserByEmail(String email) {
        return userMapper.toUserDto(userRepository.findUserByEmail(email));
    }

    @Override
    public User addUser(UserDto userDto) throws InvalidKeySpecException, NoSuchAlgorithmException {
        User user = userMapper.toUser(userDto);

        if (user.getUsername() == null ||
                user.getEmail() == null ||
                user.getPassword() == null
        ){
            return null;
        }
        else {
            user.setPassword(encoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

    }

    @Override
    public List<User> getAllUsersForUserDetails() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public Map<String, String> validateUser(UserDto userDto) {
        Map<String,String> errors = new HashMap<>();

        if (userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equals(userDto.getEmail()))
                .count() >= 1)
            errors.put("msg","Zadaný e-mail je obsadený");
        else if (!userDto.getPassword().equals(userDto.getRepeatPassword()))
            errors.put("msg","Zadajané heslá sa nezhodujú");

        return errors;
    }
}
