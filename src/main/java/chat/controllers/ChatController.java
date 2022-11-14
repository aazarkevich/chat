package chat.controllers;

import chat.models.Messages;
import chat.service.AuthoritiesUser;
import chat.service.MessagesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ChatController {
    private final AuthoritiesUser authoritiesUser;
    private final MessagesService messagesService;

    public ChatController(AuthoritiesUser authoritiesUser, MessagesService messagesService) {
        this.authoritiesUser = authoritiesUser;
        this.messagesService = messagesService;
    }

    @GetMapping
    public String index(HttpServletRequest request, Model model) {
        List<String> authoritiesUsername = authoritiesUser.getUsernames();
        String username = request.getUserPrincipal().getName();
        List<Messages> last5Rows = messagesService.findLast5Rows();

        model.addAttribute("authoritiesUsername", authoritiesUsername);
        model.addAttribute("name", username);
        model.addAttribute("messagesLast", last5Rows);

        return "chat/index.html";
    }

    @GetMapping("/saveMessage")
    @ResponseBody
    public void saveMessage(@RequestParam String message,
                            @RequestParam String username) {
        messagesService.save(message,username);
    }

}
