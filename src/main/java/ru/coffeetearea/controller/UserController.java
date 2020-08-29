package ru.coffeetearea.controller;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.dto.UserInfoDTO;
import ru.coffeetearea.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api(value = "User", tags = {"User"})
public class UserController {

    private final UserService userService;


    /**
     * Метод возвращает DTO пользователя(общую инфу)
     *
     * @return userDTO
     */
    @GetMapping
    public UserInfoDTO getInfoAboutUser() {
        return userService.getInfoAboutUser();
    }
}