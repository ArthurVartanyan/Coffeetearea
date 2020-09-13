package ru.coffeetearea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CoffeeDTO extends DrinkDTO {

    @NotNull(groups = {Edit.class})
    @NotNull(groups = {New.class})
    private GeneralCatalogDTO coffeeType;

    @NotNull(groups = {Edit.class})
    @NotNull(groups = {Edit.class})
    private GeneralCatalogDTO roasting;
}