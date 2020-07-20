package ru.coffeetearea.model;

import ru.coffeetearea.model.directory.TeaType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tea {

    public Tea(){ // Constructor for Hibernate

    }


    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    private Drink drink;

    private TeaType teaType;
}