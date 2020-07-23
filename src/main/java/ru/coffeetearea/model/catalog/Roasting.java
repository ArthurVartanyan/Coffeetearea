package ru.coffeetearea.model.catalog;

/**
 * см. класс GeneralCatalog
 */

import javax.persistence.*;

@Entity
@Table(name = "roasting")
public class Roasting extends GeneralCatalog{

    private short roasting;
}