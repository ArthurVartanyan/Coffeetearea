package ru.coffeetearea.dto;

import lombok.Data;

@Data
public class FieldErrorDTO {

    private String field;

    private String message;
}