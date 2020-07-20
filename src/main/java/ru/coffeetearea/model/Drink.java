package ru.coffeetearea.model;

import ru.coffeetearea.model.directory.Countries;
import ru.coffeetearea.model.directory.Manufacturer;
import ru.coffeetearea.model.directory.Packaging;

import javax.persistence.*;

@Entity
@Table(name = "coffeetearea", schema = "public")
public class Drink {

    public Drink(){ // Constructor for Hibernate

    }


    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "about")
    private String about;

    @Column(name = "packaging_id")
    private Packaging packaging;

    @Column(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(name = "countries_id")
    private Countries countries;
}