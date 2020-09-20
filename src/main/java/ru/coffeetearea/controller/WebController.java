package ru.coffeetearea.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/coffees")
    public String coffeesPage() {
        return "coffees";
    }

    @GetMapping("/test")
    public String testsPage() {
        return "test";
    }

    @GetMapping("/contacts")
    public String contactsPage() {
        return "contacts";
    }

    @GetMapping("/teas")
    public String teasPage() {
        return "teas";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @GetMapping("/card")
    public String cardPage() {
        return "card";
    }
}