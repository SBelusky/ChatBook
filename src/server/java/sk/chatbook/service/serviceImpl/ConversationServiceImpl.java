package sk.chatbook.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.chatbook.model.Conversation;
import sk.chatbook.model.ConversationReply;
import sk.chatbook.model.User;
import sk.chatbook.model.dto.ConversationDto;
import sk.chatbook.model.mapper.ConversationMapper;
import sk.chatbook.repository.ConversationReplyRepository;
import sk.chatbook.repository.ConversationRepository;
import sk.chatbook.repository.UserRepository;
import sk.chatbook.service.ConversationService;
import sk.chatbook.utility.ValidationHelpers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ConversationServiceImpl implements ConversationService {
    @Autowired
    ConversationRepository conversationRepository;
    @Autowired
    ConversationReplyRepository conversationReplyRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConversationMapper conversationMapper;

    @Override
    public ConversationDto getConversationById(int c_id) {
        return conversationMapper.toConversationDto(conversationRepository.findById(c_id).orElse(null));
    }

    @Override
    public List<ConversationDto> getConversationsByUser(int user_id) {
        return conversationRepository.findAll()
                .stream()
                .filter(conversation -> conversation.getUser_one().getUser_id() == user_id ||
                        conversation.getUser_two().getUser_id() == user_id)
                .map(conversation -> conversationMapper.toConversationDto(conversation))
                .collect(Collectors.toList());
    }

    @Override
    public Conversation addConversation(ConversationDto conversationDto) {
        Conversation conversation = new Conversation();

        if (conversationDto.getUser_two() == null ||
                conversationDto.getUser_one() == null) {
            return null;
        } else {
            conversation.setUser_one(userRepository.findById(conversationDto.getUser_one().getUser_id()).orElse(new User()));
            conversation.setUser_two(userRepository.findUserByEmail(conversationDto.getUser_two().getEmail()));

            return conversationRepository.save(conversation);
        }
    }

    @Override
    public Map<String, String> validateConversation(ConversationDto conversationDto) {
        Map<String, String> errors = new HashMap<>();
        User userTwo = userRepository.findUserByEmail(conversationDto.getUser_two().getEmail());

        if (conversationDto.getUser_two().getEmail() == null ||
                conversationDto.getUser_two().getEmail().matches(ValidationHelpers.NOT_BLANK_SPACES.pattern())) {
            errors.put("msg", "Zadajte email");
        } else if (!conversationDto.getUser_two().getEmail().matches(ValidationHelpers.VALID_EMAIL_ADDRESS_REGEX.pattern())) {
            errors.put("msg", "Zadajte platný e-mail");
        } else if (userRepository.findAll()
                .stream()
                .filter(user -> user.getEmail().equals(conversationDto.getUser_two().getEmail()))
                .count() == 0) {
            errors.put("msg", "Používateľ so zadaným e-mailom neexistuje");
        } else if (conversationRepository.haveUsersCreatedConversation(conversationDto.getUser_one().getUser_id(),userTwo.getUser_id()) == 1){
            errors.put("msg", "S používateľom je už vytvorená konverzácia");
        }
        else if(userTwo.getUser_id() == conversationDto.getUser_one().getUser_id()){
            errors.put("msg", "Nie je možné vytvoriť konverzáciu so sám sebou");
        }

        return errors;
    }

    // ****
    // method return list of Conversation, where logged user data are hidden with last sended message
    // ****
    @Override
    public List<ConversationDto> showOnlyOneUserInConversations(int loggedUserId, List<ConversationDto> conversationDtoList) {
        for (ConversationDto conversationDto : conversationDtoList) {
            conversationDto.setLastMsg(conversationReplyRepository.lastMessageOfConversation(conversationDto.getC_id()));
            conversationDto.setUserIdOfLastMsg(conversationReplyRepository.userIdOflastMessage(conversationDto.getC_id()));

            if (conversationDto.getUser_one().getUser_id() == loggedUserId) {
                conversationDto.setUser_one(null);
            } else {
                conversationDto.setUser_two(null);
            }
        }

        return conversationDtoList;
    }

}
