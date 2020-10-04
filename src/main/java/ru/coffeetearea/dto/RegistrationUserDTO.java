package ru.coffeetearea.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
public class RegistrationUserDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 6, max = 30)
    private String login;

    @NotBlank
    @Size(min = 6, max = 24)
    private String password;

    /**
     * Для проверки ввода пароля на корректность
     */
    @NotBlank
    @Size(min = 6, max = 24)
    private String checkPassword;

    @NotBlank
    @Email
    private String mail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationUserDTO that = (RegistrationUserDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(checkPassword, that.checkPassword) &&
                Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, login, password, checkPassword, mail);
    }
}