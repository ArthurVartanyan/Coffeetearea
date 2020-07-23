package ru.coffeetearea.model.catalog;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class GeneralCatalog {

    public @Id
    @GeneratedValue
    Long id;

    protected String name;

    protected boolean isDeleted;
}