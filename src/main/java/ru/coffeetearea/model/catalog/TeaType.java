package ru.coffeetearea.model.catalog;

import javax.persistence.*;

@Entity
@Table(name = "tea_type")
public class TeaType {

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