package ru.coffeetearea.model;

import ru.coffeetearea.model.directory.Countries;
import ru.coffeetearea.model.directory.Manufacturer;
import ru.coffeetearea.model.directory.Packaging;

import javax.persistence.*;

@Entity
@Table(name = "drink", schema = "public")
public class Drink {

    public Drink() { // Constructor for Hibernate

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

    @Column(name = "is_deleted")
    private boolean isDeleted;

    // Relationships
    //
    @ManyToOne
    @JoinColumn(name = "packaging_id")
    private Packaging packaging;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries countries;
}