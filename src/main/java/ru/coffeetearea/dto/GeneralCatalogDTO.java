package ru.coffeetearea.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GeneralCatalogDTO {

    // Fields
    //
    private Long id;

    private String name;
}