package ru.coffeetearea.dto;

import lombok.Data;

@Data
public class RegistrationUserDTO {

    private String name;

    private String lastName;

    private String login;

    private String password;

    private String mail;
}