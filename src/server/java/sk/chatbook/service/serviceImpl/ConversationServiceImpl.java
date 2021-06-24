package sk.chatbook.service.serviceImpl;

import org.springframework.stereotype.Service;
import sk.chatbook.model.dto.ConversationDto;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.model.User;
import sk.chatbook.service.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService {
    @Override
    public UserDto getConversationById(int c_id) {
        return null;
    }

    @Override
    public UserDto getConversationByUsers(int user_one_id, int user_two_id) {
        return null;
    }

    @Override
    public User addConversation(ConversationDto conversationDto) {
        return null;
    }
}
