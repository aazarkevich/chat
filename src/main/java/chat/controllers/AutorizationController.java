package chat.controllers;

import chat.dao.UserRepository;
import chat.models.User;
import chat.service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AutorizationController {
    private final UserRepository userRepository;

    public AutorizationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String login() {

        return "autorization/login.html";
    }

    @GetMapping("/logout")
    public String logout() {
//        System.out.println("Testik" + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        System.out.println("Test " + user);
        System.out.println("asdasdsadsadsda");
        return "redirect:/login.html";
    }
}
