package ru.coffeetearea.model.directory;

import javax.persistence.*;

@Entity
@Table(name = "tea_type", schema = "public")
public class TeaType {

    public TeaType() { // Constructor for Hibernate

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