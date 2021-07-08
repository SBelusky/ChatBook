package sk.chatbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.dto.ConversationReplyDto;
import sk.chatbook.service.ConversationReplyService;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("api/conversation/")
public class ConversationReplyController {
    private final ConversationReplyService conversationReplyService;

    public ConversationReplyController(ConversationReplyService conversationReplyService) {
        this.conversationReplyService = conversationReplyService;
    }

    @GetMapping("{conversationId}/conversation-reply")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getConversationRepliesByConversationId(@PathVariable int conversationId){
        List<ConversationReplyDto> conversationRepliesDtoList = conversationReplyService.getConversationRepliesByConversationId(conversationId);

        if(conversationRepliesDtoList.size() == 0){
            return new ResponseEntity<>("Replies not found / Conversation has no replies", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(conversationRepliesDtoList, HttpStatus.OK);
        }
    }

    @PostMapping("{conversationId}/add/conversation-reply")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addConversationReply(@PathVariable int conversationId, @RequestBody ConversationReplyDto conversationReplyDto){
        Map<String,String> errors = conversationReplyService.validateConversationReply(conversationReplyDto);

        if(errors.size() != 0){
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        else {
            ConversationReply conversationReply = conversationReplyService.addConversationReplay(conversationId, conversationReplyDto);

            return ResponseEntity.status(HttpStatus.CREATED).body("Conversation reply created with ID: " + conversationReply.getCr_id());
        }
    }
}
