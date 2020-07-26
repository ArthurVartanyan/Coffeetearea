package ru.coffeetearea.model;

import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.Roasting;

import javax.persistence.*;

/**
 * Класс: Кофе
 * Содержит поля: id(ИД), coffeeType(тип кофе(молотый, зерновой...)), roasting(степень обжарки).
 * Через наследование связан с классом Drink(Напиток).
 */

@Entity
@Table(name = "coffee")
public class Coffee extends Drink{

    // Relationships
    //
    @ManyToOne
    @JoinColumn(name = "type_id")
    private CoffeeType coffeeType;

    @ManyToOne
    @JoinColumn(name = "roasting_id")
    private Roasting roasting;
}