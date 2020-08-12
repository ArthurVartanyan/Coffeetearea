package ru.coffeetearea.dto;

import lombok.Data;

/**
 * DTO-класс нужен для того, чтобы при авторизации вводить только логин и пароль.
 */

@Data
public class AuthenticationRequestDTO {

    private String login;

    private String password;
}