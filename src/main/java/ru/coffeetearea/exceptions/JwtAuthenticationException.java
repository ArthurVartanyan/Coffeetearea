package ru.coffeetearea.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {

    /**
     * Конструктор
     * Вызываем родительский конструктор и передаем наше сообщение
     *
     * @param message
     */
    public JwtAuthenticationException(String message) {
        super(message);
    }
}