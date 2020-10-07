package ru.coffeetearea.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MakeOrderDTO {

    @NotBlank(message = "Заполните поле!")
    @Size(message = "Пожалуйста, введите корректный номер телефона!", min = 11, max = 11)
    private String phoneNumber;

    @NotBlank(message = "Заполните поле!")
    @Size(message = "Пожалуйста, введите корректный адрес доставки!", min = 10)
    private String address;
}