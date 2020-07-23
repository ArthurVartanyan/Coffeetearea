package ru.coffeetearea.model.catalog;

import javax.persistence.*;

@Entity
@Table(name = "roasting")
public class Roasting {

    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    @Column(name = "roasting")
    private short roasting;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}