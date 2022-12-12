package chat.service;

import chat.config.TestConfig;
import chat.dao.MessagesRepository;
import chat.models.Messages;
import chat.models.User;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class)
public class MessagesServiceTest {

    @Autowired
    private MessagesService messagesService;

    @Autowired
    private MessagesRepository messagesRepository;


    @BeforeEach
    public void setup() {
        Messages message = new Messages();
        message.setId(1L);
        message.setMessage("test");
        User user = new User();
        user.setId(1L);
        user.setPassword("12345");
        user.setUsername("UsernameTest");
        message.setUser(user);
        Messages message2 = new Messages();
        user.setPassword("54321");
        message2.setUser(user);
        List<Messages> messages = Arrays.asList(message, message2);
        when(messagesRepository.findBy5OrderById()).thenReturn(messages);
    }

    @Test
    public void findLast5Rows() {
        List<Messages> last5Rows = messagesService.findLast5Rows();
        for (Messages m : last5Rows) {
            Assertions.assertNull(m.getUser().getPassword());
        }
    }

}
