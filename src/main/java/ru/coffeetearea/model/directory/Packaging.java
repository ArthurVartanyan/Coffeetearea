package ru.coffeetearea.model.directory;

import javax.persistence.*;

@Entity
@Table(name = "packaging", schema = "public")
public class Packaging {

    public Packaging() { // Constructor for Hibernate

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