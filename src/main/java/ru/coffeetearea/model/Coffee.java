package ru.coffeetearea.model;

/**
 * Класс: Кофе
 * Содержит поля: id(ИД), coffeeType(тип кофе(молотый, зерновой...)), roasting(степень обжарки).
 * Через наследование связан с классом Drink(Напиток).
 */

import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.Roasting;

import javax.persistence.*;

@Entity
@Table(name = "coffee")
public class Coffee {

    // Fields
    //
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