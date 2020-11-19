package ru.coffeetearea.dto;

import lombok.Data;
//import ru.coffeetearea.model.Address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class MakeOrderDTO {

    @NotBlank(message = "Заполните поле!")
    @Size(message = "Пожалуйста, введите корректный номер телефона!", min = 11, max = 11)
    @Pattern(message = "Неверный формат номера!", regexp = "[0-9]{4,11}")
    private String phoneNumber;

//    @NotBlank(message = "Заполните поле!")
//    @Size(message = "Пожалуйста, введите корректный адрес доставки!", min = 10)
//    private Address address;
}