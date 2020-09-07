package ru.coffeetearea.controller;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.RegistrationUserDTO;
import ru.coffeetearea.dto.UserDTO;
import ru.coffeetearea.dto.UserInfoDTO;
import ru.coffeetearea.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Api(value = "User", tags = {"User"})
public class UserController {

    private final UserService userService;


    /**
     * Метод возвращает DTO пользователя(общую инфу)
     *
     * @return userDTO
     */
    @GetMapping("/info")
    public UserInfoDTO getInfoAboutUser() {
        return userService.getInfoAboutUser();
    }


    /**
     * Метод регистрации пользователя
     * @param registrationUserDTO
     */
    @PostMapping("/registration")
    public UserDTO registration(@Validated @RequestBody RegistrationUserDTO registrationUserDTO) {

        return userService.registration(registrationUserDTO);
    }
}