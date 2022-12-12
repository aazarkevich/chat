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

    public MessagesService(MessagesRepository messagesRepository, UserRepository userRepository) {
        this.messagesRepository = messagesRepository;
        this.userRepository = userRepository;
    }

    public List<Messages> findLast5Rows() {
        List<Messages> messages5OrderById = messagesRepository.findBy5OrderById();
        Collections.reverse(messages5OrderById);
        for (Messages m : messages5OrderById) {
            m.getUser().setPassword(null);
        }
        return messages5OrderById;
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
