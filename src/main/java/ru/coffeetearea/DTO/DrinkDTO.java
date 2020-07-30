package ru.coffeetearea.DTO;

import lombok.Data;
import ru.coffeetearea.DTO.catalogDTO.GeneralCatalogDTO;
import ru.coffeetearea.model.catalog.Countries;
import ru.coffeetearea.model.catalog.Manufacturer;
import ru.coffeetearea.model.catalog.Packaging;

@Data
public class DrinkDTO {

    // Fields
    //
    private Long id;

    private String name;

    private float price;

    private String about;

    private GeneralCatalogDTO<Packaging> packaging;

    private GeneralCatalogDTO<Manufacturer> manufacturer;

    private GeneralCatalogDTO<Countries> countries;
}