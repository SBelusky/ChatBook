package sk.chatbook.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.chatbook.model.User;
import sk.chatbook.model.dto.ConversationReplyDto;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.model.mapper.ConversationMapper;
import sk.chatbook.repository.ConversationReplyRepository;
import sk.chatbook.service.ConversationReplyService;

@Service
public class ConversationReplyServiceImpl implements ConversationReplyService {
    @Autowired
    ConversationReplyRepository conversationReplyRepository;
    @Autowired
    ConversationMapper conversationMapper;

    @Override
    public UserDto getConversationReplyes(int c_id) {
//        return conversationReplyRepository.findById()
        return null;
    }

    @Override
    public User addConversationReplay(ConversationReplyDto conversationReplyDto) {
        return null;
    }
}
