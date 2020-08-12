package ru.coffeetearea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.Roasting;

@Data
@EqualsAndHashCode(callSuper = true)
public class CoffeeDTO extends DrinkDTO {

    private CoffeeType coffeeType;

    private Roasting roasting;
}