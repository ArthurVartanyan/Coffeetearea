package ru.coffeetearea.model.catalog;

import javax.persistence.*;

/**
 * Класс - справочник "Тип кофе".
 * Типы кофе, например: "молотый", "зерновой" и т.д.
 */

@Entity
@Table(name = "coffee_type")
public class CoffeeType extends GeneralCatalog{
}