package ru.coffeetearea.model;

import lombok.Getter;
import lombok.Setter;
import ru.coffeetearea.model.catalog.CoffeeType;
import ru.coffeetearea.model.catalog.Roasting;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "coffee")
public class Coffee extends Drink {

    /**
     * Тип кофе
     */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private CoffeeType coffeeType;

    /**
     * Тип обжарки кофе
     */
    @ManyToOne
    @JoinColumn(name = "roasting_id")
    private Roasting roasting;
}