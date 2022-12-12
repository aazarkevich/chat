package chat.config;

import chat.dao.MessagesRepository;
import chat.dao.UserRepository;
import chat.service.MessagesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {

    @Bean
    public MessagesService messagesService() {
        return new MessagesService(messagesRepository(), userRepository());
    }

    @Bean
    public MessagesRepository messagesRepository() {
        return mock(MessagesRepository.class);
    }

    @Bean
    public UserRepository userRepository() {
        return mock(UserRepository.class);
    }

}
