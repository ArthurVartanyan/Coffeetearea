package ru.coffeetearea.dto;

import lombok.Data;

@Data
public class DrinkDTO {

    protected Long id;

    protected String name;

    protected float price;

    protected String about;

    protected GeneralCatalogDTO packaging;

    protected GeneralCatalogDTO manufacturer;

    protected GeneralCatalogDTO country;
}