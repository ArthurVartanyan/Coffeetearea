package ru.coffeetearea.DTO.catalogDTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GeneralCatalogDTO<T> {

    // Fields
    //
    private Long id;

    private String name;
}