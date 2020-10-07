package ru.coffeetearea.model.catalog;

import javax.persistence.*;

/**
 * Класс - справочник "Страны".
 * У каждого напитка своя страна производства.
 */

@Entity
@Table(name = "countries")
public class Country extends GeneralCatalog{
}