package chat.service;

import chat.dao.MessagesRepository;
import chat.dao.UserRepository;
import chat.models.Messages;
import chat.models.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MessagesService {
    private final MessagesRepository messagesRepository;
    private final UserRepository userRepository;

    public MessagesService(MessagesRepository messagesRepository, UserRepository userRepository, SessionFactory sessionFactory) {
        this.messagesRepository = messagesRepository;
        this.userRepository = userRepository;
    }

    public List<Messages> findLast5Rows() {
        List<Messages> messages10OrderById = messagesRepository.findBy5OrderById();
        Collections.reverse(messages10OrderById);
        for (Messages m : messages10OrderById) {
            m.getUser().setPassword(null);
        }
        return messages10OrderById;
    }

    public void save(String message, String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        Messages messages = new Messages();
        messages.setMessage(message);
        messages.setUserId(user.getId());
        messages.setUser(user);
        messagesRepository.save(messages);
    }
}
