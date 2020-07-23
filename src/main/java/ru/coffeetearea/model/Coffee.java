package ru.coffeetearea.model;

import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.Roasting;

import javax.persistence.*;

@Entity
@Table(name = "coffee")
public class Coffee {

    // Fields
    //

    // Other fields are in parent class Drink (with RelationShips)

    private @Id
    @GeneratedValue
    Long id;

    // Relationships
    //
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drink_id")
    private Drink drink;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CoffeeType coffeeType;

    @ManyToOne
    @JoinColumn(name = "roasting_id")
    private Roasting roasting;
}