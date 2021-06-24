package sk.chatbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sk.chatbook.model.User;
import sk.chatbook.model.dto.UserDto;
import sk.chatbook.repository.UserRepository;
import sk.chatbook.service.UserService;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class ChatBookApplicationTest {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200(){
//        UserDto u = service.getUserByEmail("a");
        List<User> u = repository.findAll();
        System.out.println(u.size());
    }


}
