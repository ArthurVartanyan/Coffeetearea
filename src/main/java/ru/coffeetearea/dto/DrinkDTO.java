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

    @NotNull(message = "Заполните поле!", groups = {New.class, Edit.class})
    @DecimalMin(message = "Цена должна быть не меньше 100 рублей", value = "100.0", groups = {New.class, Edit.class})
    @Pattern(message = "Неверный формат цены!", regexp = "[0-9]{100,10000}")
    protected BigDecimal price;

    @NotBlank(message = "Заполните поле!", groups = {New.class, Edit.class})
    @Size(message = "Описание должно быть не меньше 20 символов!", min = 20, groups = {New.class, Edit.class})
    protected String about;

    @NotNull(message = "Заполните поле!", groups = {Edit.class, New.class})
    @Min(message = "Вес должен быть не меньше 10 грамм", value = 10, groups = {Edit.class, New.class})
    protected int weight;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO packaging;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO manufacturer;

    @NotNull(groups = {New.class, Edit.class})
    protected GeneralCatalogDTO country;
}