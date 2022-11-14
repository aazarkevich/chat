package chat.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthoritiesUser {
    private List<String> usernames;

    public AuthoritiesUser() {
        this.usernames = new ArrayList<>();
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void addAuthoritiesUsername (String username) {
        usernames.add(username);
    }

    public void deleteAuthoritiesUsername(String username) {
        usernames.remove(username);
    }
}
