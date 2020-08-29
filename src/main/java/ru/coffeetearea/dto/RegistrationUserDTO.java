package ru.coffeetearea.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistrationUserDTO {

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    @Size(min = 6, max = 30)
    private String login;

    @NotNull
    @Size(min = 6, max = 24)
    private String password;

    /**
     * Для проверки ввода пароля на корректность
     */
    @NotNull
    @Size(min = 6, max = 24)
    private String checkPassword;

    @NotNull
    @Email
    private String mail;
}