package chat.controllers;

import chat.service.AuthoritiesUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChatController {
    private final AuthoritiesUser authoritiesUser;

    public ChatController(AuthoritiesUser authoritiesUser) {
        this.authoritiesUser = authoritiesUser;
    }

    @GetMapping
    public String index(Model model) {
        List<String> authoritiesUsername = authoritiesUser.getUsernames();
        model.addAttribute("authoritiesUsername", authoritiesUsername);
        return "chat/index.html";
    }
}
