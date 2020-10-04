package ru.coffeetearea.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class DrinkDTO {

    public interface New {

    }

    public interface Edit {

    }

    @Null(groups = {New.class, Edit.class})
    protected Long id;

    @NotBlank(groups = {New.class, Edit.class})
    protected String name;

    protected String image;

    @NotNull(groups = {New.class, Edit.class})
    @DecimalMin(value = "100.0", groups = {New.class, Edit.class})
    protected BigDecimal price;

    @NotBlank(groups = {New.class, Edit.class})
    @Size(min = 20, groups = {New.class, Edit.class})
    protected String about;

    @NotNull(groups = {Edit.class, New.class})
    @Min(value = 10, groups = {Edit.class, New.class})
    protected int weight;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO packaging;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO manufacturer;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO country;
}