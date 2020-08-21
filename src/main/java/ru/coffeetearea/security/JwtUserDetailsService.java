package ru.coffeetearea.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.model.User;
import ru.coffeetearea.repository.UserRepository;
import ru.coffeetearea.security.jwt.JwtUser;
import ru.coffeetearea.security.jwt.JwtUserFactory;
import ru.coffeetearea.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

//    private final UserService userService;

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("Внимание! Невозможно найти login: " + login));

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with login: {} successfully loaded", login);
        return jwtUser;
    }
}