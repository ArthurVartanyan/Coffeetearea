package ru.coffeetearea.model.directory;

import javax.persistence.*;

@Entity
@Table(name = "manufacturer", schema = "public")
public class Manufacturer {

    public Manufacturer() { // Constructor for Hibernate

    }


    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}