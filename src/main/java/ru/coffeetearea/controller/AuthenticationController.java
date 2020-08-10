package ru.coffeetearea.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.dto.AuthenticationRequestDTO;
import ru.coffeetearea.model.User;
import ru.coffeetearea.security.jwt.JwtTokenProvider;
import ru.coffeetearea.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    // Fields
    //
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;
    //


    // GET-Methods
    //
    //
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthenticationRequestDTO requestDto) {
        try {
            String login = requestDto.getLogin();
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(login, requestDto.getPassword()));

            User user = userService.findByLogin(login);

            String token = jwtTokenProvider.createToken(login, user.getRole());

            Map<String, String> response = new HashMap<>();
            response.put("login", login);
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid login or password");
        }
    }
}