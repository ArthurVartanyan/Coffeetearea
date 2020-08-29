package ru.coffeetearea.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class DrinkDTO {

    public interface New {

    }

    @Null(groups = {New.class})
    protected Long id;

    @NotNull(groups = {New.class})
    protected String name;

    @NotNull(groups = {New.class})
    @DecimalMin("100.0")
    protected BigDecimal price;

    @NotNull(groups = {New.class})
    @Size(min = 20)
    protected String about;

    @NotNull(groups = {New.class})
    @Min(value = 10)
    protected int weight;

    @NotNull(groups = {New.class})
    protected GeneralCatalogDTO packaging;

    @NotNull(groups = {New.class})
    protected GeneralCatalogDTO manufacturer;

    @NotNull(groups = {New.class})
    protected GeneralCatalogDTO country;
}