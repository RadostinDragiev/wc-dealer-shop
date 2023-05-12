package com.example.wcdealershop.web;

import com.example.wcdealershop.models.dtos.UserRegisterDto;
import com.example.wcdealershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String createUser(UserRegisterDto userRegisterDto) {
        this.userService.registerUser(userRegisterDto);
        return "redirect:/";
    }
}
