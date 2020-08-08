package ru.coffeetearea.security.jwt;

import ru.coffeetearea.model.User;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getLogin(),
                user.getPassword(),
                user.getMail(),
                user.isDeleted(),
                user.getRole()
        );
    }
}