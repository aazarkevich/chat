package chat.controllers;

import chat.dao.UserRepository;
import chat.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AutorizationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping()
    public String login() {
        User us101 = userRepository.findById(1l).get();
        System.out.println("Testik " + us101);
        return "autorization/login.html";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login.html";
    }
}
