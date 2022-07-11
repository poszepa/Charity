package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.AuthService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {


    @GetMapping
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

}
