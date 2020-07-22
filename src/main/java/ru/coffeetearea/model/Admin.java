package ru.coffeetearea.model;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public")
public class Admin {

    public Admin() { // Constructor for Hibernate

    }


    // Fields
    //

    // other fields are in the User class

    private @Id
    @GeneratedValue
    Long id;

    // Relationships
    //
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}