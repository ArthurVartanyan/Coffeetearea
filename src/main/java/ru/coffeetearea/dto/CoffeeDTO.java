package ru.coffeetearea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CoffeeDTO extends DrinkDTO {

    @NotNull(groups = {Edit.class, New.class})
    private GeneralCatalogDTO coffeeType;

    @NotNull(groups = {Edit.class, Edit.class})
    private GeneralCatalogDTO roasting;
}