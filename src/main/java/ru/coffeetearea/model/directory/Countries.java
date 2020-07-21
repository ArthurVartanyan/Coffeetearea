package ru.coffeetearea.model.directory;

import javax.persistence.*;

@Entity
@Table(name = "countries", schema = "public")
public class Countries {

    public Countries() { // Constructor for Hibernate

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