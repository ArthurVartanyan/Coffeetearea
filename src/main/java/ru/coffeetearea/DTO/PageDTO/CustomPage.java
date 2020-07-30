package ru.coffeetearea.DTO.PageDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomPage {

    Long totalElements;

    int totalPages;

    int number;

    int size;
}