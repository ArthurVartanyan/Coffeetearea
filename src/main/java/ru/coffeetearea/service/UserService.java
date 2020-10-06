package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.coffeetearea.dto.AuthenticationRequestDTO;
import ru.coffeetearea.dto.RegistrationUserDTO;
import ru.coffeetearea.dto.UserDTO;
//import ru.coffeetearea.dto.UserInfoDTO;
import ru.coffeetearea.exceptions.BadRequestException;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.mappers.UserMapper;
import ru.coffeetearea.model.Role;
import ru.coffeetearea.model.User;
import ru.coffeetearea.repository.UserRepository;
import ru.coffeetearea.security.jwt.JwtTokenProvider;
import ru.coffeetearea.security.jwt.JwtUser;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;


    /**
     * Регистрация пользователя
     *
     * @param requestDto
     * @return OK status with token
     */
    public ResponseEntity<Map<String, String>> authorization(@RequestBody AuthenticationRequestDTO requestDto) {
        try {
            String login = requestDto.getLogin();
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(login, requestDto.getPassword()));

            User user = findByLogin(login);

            if (user == null) {
                throw new AuthenticationServiceException("NULL!");
            }

            String token = jwtTokenProvider.createToken(login, user.getRole());

            Map<String, String> response = new HashMap<>();
            response.put("login", login);
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (AuthenticationServiceException e) {
            log.error("Error: ", e);
            throw new AuthenticationServiceException("Invalid login");
        }
    }


    /**
     * Метод возвращает DTO пользователя(общую инфу)
     *
     * @return userDTO
     */
    public UserDTO getInfoAboutUser() {

        User user = userRepository.getById(JwtUser.getCurrentUserID());

        return userMapper.userToUserDTO(user);
    }


    /**
     * Регистрация пользователя
     *
     * @param registrationUserDTO
     */
    public UserDTO registration(RegistrationUserDTO registrationUserDTO) {

        User user = userMapper.registrationUserDTOtoUser(registrationUserDTO);

        if (userRepository.getByLogin(registrationUserDTO.getLogin()) != null) {

            throw new BadRequestException("Внимание! Пользователь с таким логином уже сущетсвует!");
        }

        if (StringUtils.equals(registrationUserDTO.getCheckPassword(), registrationUserDTO.getPassword())) {
            user.setPassword(passwordEncoder.encode(registrationUserDTO.getPassword()));
        } else {
            throw new BadRequestException("Внимание! Пароли отличаются!");
        }
        user.setRole(Role.CUSTOMER);
        user.setDeleted(false);

        userRepository.save(user);

        return userMapper.userToUserDTO(user);
    }


    /**
     * Поиск пользователя по логину
     *
     * @param login
     * @return USER
     */
    public User findByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("Внимание! Невозможно найти login: " + login));
    }
}