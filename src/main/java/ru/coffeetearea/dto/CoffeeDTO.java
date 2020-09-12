package ru.coffeetearea.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.RequestParam;
import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.GeneralCatalog;
import ru.coffeetearea.model.catalog.Roasting;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class CoffeeDTO extends DrinkDTO {

    @NotNull(groups = {Edit.class})
    @NotNull(groups = {New.class})
    private GeneralCatalogDTO coffeeType;

    @NotNull(groups = {Edit.class})
    @NotNull(groups = {Edit.class})
    private GeneralCatalogDTO roasting;
}