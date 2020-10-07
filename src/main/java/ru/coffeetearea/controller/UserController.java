package ru.coffeetearea.controller;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.AuthenticationRequestDTO;
import ru.coffeetearea.dto.RegistrationUserDTO;
import ru.coffeetearea.dto.UserDTO;
//import ru.coffeetearea.dto.UserInfoDTO;
import ru.coffeetearea.service.UserService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Api(value = "User", tags = {"User"})
public class UserController {

    private final UserService userService;


    /**
     * Авторизация пользователя
     *
     * @param requestDTO
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> authorization(@RequestBody AuthenticationRequestDTO requestDTO) {

        return userService.authorization(requestDTO);
    }


    /**
     * Метод возвращает DTO пользователя(общую инфу)
     *
     * @return userDTO
     */
    @GetMapping("/info")
    public UserDTO getInfoAboutUser() {
        return userService.getInfoAboutUser();
    }


    /**
     * Метод регистрации пользователя
     *
     * @param registrationUserDTO
     */
    @PostMapping("/registration")
    public UserDTO registration(@Validated @RequestBody RegistrationUserDTO registrationUserDTO) {

        return userService.registration(registrationUserDTO);
    }
}