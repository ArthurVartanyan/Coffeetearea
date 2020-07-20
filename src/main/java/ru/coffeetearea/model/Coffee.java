package ru.coffeetearea.model;


import ru.coffeetearea.model.directory.CoffeeType;
import ru.coffeetearea.model.directory.Roasting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coffee {

    public Coffee() { // Constructor for Hibernate

    }


    // Fields
    //

    // Other fields are in parent class Drink (with RelationShips)

    private @Id
    @GeneratedValue
    Long id;

    private Drink drink;

    private CoffeeType coffeeType;

    private Roasting roasting;
}