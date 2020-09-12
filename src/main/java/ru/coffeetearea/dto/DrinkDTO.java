package ru.coffeetearea.dto;

import lombok.Data;
import ru.coffeetearea.model.catalog.GeneralCatalog;
import ru.coffeetearea.model.catalog.Packaging;

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

//    protected String image;

    @NotNull(groups = {New.class, Edit.class})
    @DecimalMin("100.0")
    protected BigDecimal price;

    @NotNull(groups = {New.class})
    @NotNull(groups = {Edit.class})
    @Size(min = 20)
    protected String about;

    @NotNull(groups = {New.class, Edit.class})
    @Min(value = 10)
    protected int weight;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO packaging;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO manufacturer;

    @NotNull(groups = {New.class})
    @NotNull(groups = {Edit.class})
    protected GeneralCatalogDTO country;
}