package chat.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
