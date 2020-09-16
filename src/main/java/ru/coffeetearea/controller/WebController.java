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
}