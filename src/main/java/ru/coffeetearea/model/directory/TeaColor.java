package ru.coffeetearea.model.directory;

import javax.persistence.*;

@Entity
@Table(name = "tea_color", schema = "public")
public class TeaColor {

    public TeaColor() { // Constructor for Hibernate

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