package ru.coffeetearea.DTO;

import lombok.Data;
import ru.coffeetearea.model.catalog.Countries;
import ru.coffeetearea.model.catalog.Manufacturer;
import ru.coffeetearea.model.catalog.Packaging;

@Data
public class DrinkDTO {

    // Fields
    //
    private String name;

    private float price;

    private String about;

    private Packaging packaging;

    private Manufacturer manufacturer;

    private Countries countries;
}