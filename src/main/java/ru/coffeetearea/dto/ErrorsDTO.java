package ru.coffeetearea.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorsDTO {

    private String error;

    private List<FieldErrorDTO> fieldErrors;
}
