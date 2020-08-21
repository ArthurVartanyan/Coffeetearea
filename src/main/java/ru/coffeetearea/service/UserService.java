package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.RegistrationUserDTO;
import ru.coffeetearea.dto.UserDTO;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.mappers.UserMapper;
import ru.coffeetearea.model.Role;
import ru.coffeetearea.model.User;
import ru.coffeetearea.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;


    /**
     * Регистрация пользователя
     *
     * @param registrationUserDTO
     */
    public UserDTO registration(RegistrationUserDTO registrationUserDTO) {

        User user = new User();

        user.setName(registrationUserDTO.getName());
        user.setLastName(registrationUserDTO.getLastName());
        user.setLogin(registrationUserDTO.getLogin());
        user.setMail(registrationUserDTO.getMail());
        user.setPassword(passwordEncoder.encode(registrationUserDTO.getPassword()));
        user.setRole(Role.CUSTOMER);

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