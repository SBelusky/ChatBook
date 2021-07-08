package sk.chatbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.chatbook.model.User;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.service.UserService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/")
public class UserController{
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getUserByEmail(@RequestBody UserDto userDto){
        UserDto responseUserDto = userService.getUserByEmail(userDto.getEmail());

        if(responseUserDto == null){
            return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
        }
    }

    @PostMapping("add/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Map<String,String> errors = userService.validateUser(userDto);

        if(errors.size() != 0){
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        else {
            User user = userService.addUser(userDto);

            return ResponseEntity.status(HttpStatus.CREATED).body("User created with ID: "+ user.getUser_id());
        }
    }
}
