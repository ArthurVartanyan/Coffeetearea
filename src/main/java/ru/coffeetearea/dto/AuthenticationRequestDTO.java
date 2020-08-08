package ru.coffeetearea.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

    private String login;

    private String password;
}