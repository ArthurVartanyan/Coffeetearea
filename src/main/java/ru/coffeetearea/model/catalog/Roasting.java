package ru.coffeetearea.model.catalog;

import javax.persistence.*;

@Entity
@Table(name = "roasting")
public class Roasting extends GeneralCatalog{

    private short roasting;
}