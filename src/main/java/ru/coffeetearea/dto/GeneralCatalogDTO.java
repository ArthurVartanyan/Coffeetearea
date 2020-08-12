package ru.coffeetearea.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GeneralCatalogDTO {

    private Long id;

    private String name;
}