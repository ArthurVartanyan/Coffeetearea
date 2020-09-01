package ru.coffeetearea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.Roasting;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class CoffeeDTO extends DrinkDTO {

    @NotNull(groups = {New.class})
    private CoffeeType coffeeType;

    @NotNull(groups = {New.class})
    private Roasting roasting;
}