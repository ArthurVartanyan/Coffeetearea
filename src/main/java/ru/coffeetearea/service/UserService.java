package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffeetearea.exceptions.MainNotFound;
import ru.coffeetearea.model.User;
import ru.coffeetearea.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Поиск пользователя по логину
     *
     * @param login
     * @return USER
     */
    public User findByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new MainNotFound(login));
    }
}