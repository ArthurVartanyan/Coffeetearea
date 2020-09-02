package ru.coffeetearea.model.catalog;

import javax.persistence.*;

/**
 * см. класс GeneralCatalog
 */

@Entity
@Table(name = "coffee_type")
public class CoffeeType extends GeneralCatalog{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coffee_type_id_seq")
    @SequenceGenerator(name = "coffee_type_id_seq", sequenceName = "coffee_type_id_seq", allocationSize = 1)
    protected Long id;
}