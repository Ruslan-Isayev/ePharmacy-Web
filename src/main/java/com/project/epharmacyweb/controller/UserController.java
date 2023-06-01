package com.project.epharmacyweb.controller;

import com.project.epharmacyweb.utility.Utility;
import com.project.epharmacyweb.entity.User;
import com.project.epharmacyweb.repository.UserRepository;
import com.project.epharmacyweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final Utility utility;

    @GetMapping("/register-form")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        user.setConfirmationStatus("pending");
        user.setConfirmationToken(UUID.randomUUID().toString());
        model.addAttribute("user", userRepository.save(user));
        utility.sendConfirmationEmail(user);
        return "registration-confirmation";
    }

    @GetMapping("/confirm-registration/{confirmationToken}")
    public String confirmRegistration(@PathVariable String confirmationToken, Model model) {
        Optional<User> optionalUser = userRepository.findByConfirmationToken(confirmationToken);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setConfirmationStatus("confirmed");
            userRepository.save(user);
            model.addAttribute("message", "Registration confirmed successfully. You can now log in.");
        } else {
            model.addAttribute("error", "Registration invalid!");
        }
        return "login";
    }

    @GetMapping("/login-form")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (optionalUser.isPresent()) {
            model.addAttribute("message", "Successfully logged in!");
            return "login";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "login";
        }
    }


}
