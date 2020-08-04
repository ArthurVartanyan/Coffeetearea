package ru.coffeetearea.model;

import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.Roasting;

import javax.persistence.*;

@Entity
@Table(name = "coffee")
public class Coffee extends Drink {

    // Relationships
    //
    /** Тип кофе */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private CoffeeType coffeeType;

    /** Тип обжарки кофе */
    @ManyToOne
    @JoinColumn(name = "roasting_id")
    private Roasting roasting;
}