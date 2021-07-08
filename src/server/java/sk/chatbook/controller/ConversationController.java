package sk.chatbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.dto.ConversationDto;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.service.ConversationService;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/")
public class ConversationController {
    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("conversation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getConversationsByUser(@RequestBody UserDto userDto){
        List<ConversationDto> conversationDtoList = conversationService.showOnlyOneUserInConversations(userDto.getUser_id(), conversationService.getConversationsByUser(userDto.getUser_id()));

        if(conversationDtoList.size() == 0){
            return new ResponseEntity<>("Conversations not found / User has no conversation", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(conversationDtoList, HttpStatus.OK);
        }
    }

    @GetMapping("conversation/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getConversationById(@PathVariable("id") Integer id){
        ConversationDto conversationDto = conversationService.getConversationById(id);

        if(conversationDto == null){
            return new ResponseEntity<>("Conversation not found", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(conversationDto, HttpStatus.OK);
        }
    }

    @PostMapping("add/conversation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addConversation(@RequestBody ConversationDto conversationDto){
        Map<String,String> errors = conversationService.validateConversation(conversationDto);

        if(errors.size() != 0){
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        else {
            Conversation conversation = conversationService.addConversation(conversationDto);

            return ResponseEntity.status(HttpStatus.CREATED).body("Conversation created with ID: "+ conversation.getC_id());
        }
    }

}
