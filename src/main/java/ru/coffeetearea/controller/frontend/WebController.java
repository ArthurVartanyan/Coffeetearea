package ru.coffeetearea.controller.frontend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.controller.UserController;
import ru.coffeetearea.dto.AuthenticationRequestDTO;
import ru.coffeetearea.model.User;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final UserController userController;


    @GetMapping("/hello")
    public String home(@RequestParam(name = "name", required = false, defaultValue = "World") AuthenticationRequestDTO requestDTO,
                       Model model) {
        model.addAttribute("user", requestDTO);
        return "hello";
    }


    @GetMapping("/login")
    public String loginForm(Model model, AuthenticationRequestDTO requestDTO) {
        model.addAttribute("requestDTO", requestDTO);
        model.addAttribute("auth", userController);
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute AuthenticationRequestDTO requestDTO, Model model){
        model.addAttribute("requestDTO", requestDTO);
        model.addAttribute("auth", userController.authorization(requestDTO));
        return "hello";
    }
}