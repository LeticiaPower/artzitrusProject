package com.leticia.zitrus.artzitrus.controller;

import com.leticia.zitrus.artzitrus.model.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    private PasswordEncoder encoder;
    private UserRepository repository;

    public UserController(UserRepository repository, PasswordEncoder encoder) {
        this.encoder = encoder;
        this.repository = repository;
    }

    @GetMapping("/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        return "/login";
    }
}
