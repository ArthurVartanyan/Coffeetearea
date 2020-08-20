package ru.coffeetearea.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DrinkDTO {

    protected Long id;

    protected String name;

    protected BigDecimal price;

    protected String about;

    protected int weight;

    protected GeneralCatalogDTO packaging;

    protected GeneralCatalogDTO manufacturer;

    protected GeneralCatalogDTO country;
}