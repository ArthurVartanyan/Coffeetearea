package ru.coffeetearea.model.directory;

import javax.persistence.*;

@Entity
@Table(name = "roasting", schema = "public")
public class Roasting {

    public Roasting() { // Constructor for Hibernate

    }


    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    @Column(name = "roasting")
    private String roasting;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}