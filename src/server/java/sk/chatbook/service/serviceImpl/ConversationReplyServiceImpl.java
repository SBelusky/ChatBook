package sk.chatbook.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.User;
import sk.chatbook.model.compositeKey.ConversationReplyKey;
import sk.chatbook.model.dto.ConversationReplyDto;
import sk.chatbook.model.mapper.ConversationReplyMapper;
import sk.chatbook.repository.ConversationReplyRepository;
import sk.chatbook.repository.ConversationRepository;
import sk.chatbook.repository.UserRepository;
import sk.chatbook.service.ConversationReplyService;
import sk.chatbook.utility.ValidationHelpers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConversationReplyServiceImpl implements ConversationReplyService {
    @Autowired
    ConversationReplyRepository conversationReplyRepository;
    @Autowired
    ConversationRepository conversationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConversationReplyMapper conversationReplyMapper;

    @Override
    public List<ConversationReplyDto> getConversationRepliesByConversationId(int c_id) {
        return conversationReplyRepository.findAll()
                .stream()
                .filter(conversationReply -> conversationReply.getConversation().getC_id() == c_id)
                .map(conversationReply -> conversationReplyMapper.toConversationReplyDto(conversationReply))
                .collect(Collectors.toList());
    }

    @Override
    public ConversationReply addConversationReplay(int conversationId, ConversationReplyDto conversationReplyDto) {
        ConversationReply conversationReply = new ConversationReply();

        if (conversationReplyDto.getUser() == null ||
            conversationReplyDto.getReply() == null) {
            return null;
        } else {
            conversationReply.setUser(userRepository.findById(conversationReplyDto.getUser().getUser_id()).orElse(new User()));
            conversationReply.setReply(conversationReplyDto.getReply());
            conversationReply.setConversation(conversationRepository.findById(conversationId).orElse(new Conversation()));
            conversationReply.setTime(Timestamp.from(Instant.now()));

            return conversationReplyRepository.save(conversationReply);
        }

    }

    @Override
    public Map<String, String> validateConversationReply(ConversationReplyDto conversationReplyDto) {
        Map<String, String> errors = new HashMap<>();

        if (conversationReplyDto.getReply().matches(ValidationHelpers.NOT_BLANK_SPACES.pattern())) {
            errors.put("reply", "Zadajte odpoveď");
        }

        return errors;
    }
}
