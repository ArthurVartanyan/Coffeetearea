package ru.coffeetearea.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Objects;

@Data
public class RegistrationUserDTO {

    @NotBlank(message = "Заполните поле!")
    private String name;

    @NotBlank(message = "Заполните поле!")
    private String lastName;

    @NotBlank(message = "Заполните поле!")
    @Size(message = "Длина логина должна быть не меньше 6 и не больше 30 символов", min = 6, max = 30)
    @Pattern(message = "Неверный формат логина!", regexp = "[a-zA-Z0-9_]{3,12}")
    private String login;

    @NotBlank(message = "Заполните поле!")
    @Size(message = "Длина пароля должна быть не меньше 6 и не больше 24 символов", min = 6, max = 24)
    private String password;

    /**
     * Для проверки ввода пароля на корректность
     */
    @NotBlank(message = "Заполните поле!")
    @Size(message = "Длина пароля должна быть не меньше 6 и не больше 24 символов", min = 6, max = 24)
    private String checkPassword;

    @NotBlank(message = "Заполните поле!")
    @Email(message = "Пожалуйста, введите корректный почтовый адрес!")
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