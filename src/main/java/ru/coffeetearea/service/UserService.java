package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.RegistrationUserDTO;
import ru.coffeetearea.dto.UserDTO;
import ru.coffeetearea.dto.UserInfoDTO;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.exceptions.MainIllegalArgumentException;
import ru.coffeetearea.mappers.UserMapper;
import ru.coffeetearea.model.Role;
import ru.coffeetearea.model.User;
import ru.coffeetearea.repository.UserRepository;
import ru.coffeetearea.security.jwt.JwtUser;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;


    /**
     * Метод возвращает DTO пользователя(общую инфу)
     *
     * @return userDTO
     */
    public UserInfoDTO getInfoAboutUser() {

        User user = userRepository.getById(JwtUser.getCurrentUserID());

        return userMapper.userToUserInfoDTO(user);
    }


    /**
     * Регистрация пользователя
     *
     * @param registrationUserDTO
     */
    public UserDTO registration(RegistrationUserDTO registrationUserDTO) {

        User user = userMapper.registrationUserDTOtoUser(registrationUserDTO);

//        user.setName(registrationUserDTO.getName());
//        user.setLastName(registrationUserDTO.getLastName());
//        user.setLogin(registrationUserDTO.getLogin());
//        user.setMail(registrationUserDTO.getMail());
        if (registrationUserDTO.getCheckPassword().equals(registrationUserDTO.getPassword())) {
            user.setPassword(passwordEncoder.encode(registrationUserDTO.getPassword()));
        } else {
            throw new MainIllegalArgumentException("Ошибка! Пароли не совпадают!");
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