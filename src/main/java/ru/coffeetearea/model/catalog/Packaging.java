package ru.coffeetearea.model.catalog;

import javax.persistence.*;

@Entity
@Table(name = "packaging")
public class Packaging {

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