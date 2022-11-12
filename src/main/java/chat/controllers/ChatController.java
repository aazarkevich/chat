package chat.controllers;

import chat.service.AuthoritiesUser;
import chat.service.UserDetailsServiceImp;
import chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChatController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthoritiesUser authoritiesUser;

    @GetMapping
    public String index() {
        List<String> authoritiesUsername = authoritiesUser.getUsernames();
        for (String name : authoritiesUsername) {
            System.out.println("namer : " + name);
        }
        return "chat/index.html";
    }
}
