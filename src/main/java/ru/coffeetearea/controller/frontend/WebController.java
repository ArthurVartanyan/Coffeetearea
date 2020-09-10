package ru.coffeetearea.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {


    @GetMapping("/hello")
    public String home(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                       Model model) {
        model.addAttribute("name", name);
        return "hello";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }
}