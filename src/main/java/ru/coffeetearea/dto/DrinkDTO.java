package ru.coffeetearea.dto;

import lombok.Data;
import ru.coffeetearea.model.catalog.GeneralCatalog;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class DrinkDTO {

    public interface New {

    }

    public interface Edit {

    }

    @Null(groups = {New.class, Edit.class})
    protected Long id;

    @NotNull(groups = {New.class, Edit.class})
    protected String name;

    @NotNull(groups = {New.class, Edit.class})
    @DecimalMin("100.0")
    protected BigDecimal price;

    @NotNull(groups = {New.class, Edit.class})
    @Size(min = 20)
    protected String about;

    @NotNull(groups = {New.class, Edit.class})
    @Min(value = 10)
    protected int weight;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO packaging;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO manufacturer;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO country;
}