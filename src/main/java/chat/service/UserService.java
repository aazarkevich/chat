package chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
//    private final SessionRegistry sessionRegistry;
//
//    public UserService(SessionRegistry sessionRegistry) {
//        this.sessionRegistry = sessionRegistry;
//    }
//
//    public List<UserDetails> findAllLoggedInUsers() {
//        return sessionRegistry.getAllPrincipals()
//                .stream()
//                .filter(principal -> principal instanceof UserDetails)
//                .map(UserDetails.class::cast)
//                .collect(Collectors.toList());
//    }
}
