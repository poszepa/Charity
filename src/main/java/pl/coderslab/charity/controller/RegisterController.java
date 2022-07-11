package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    @GetMapping
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String register(@ModelAttribute("User")@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/";

    }
}
