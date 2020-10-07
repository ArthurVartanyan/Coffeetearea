package ru.coffeetearea.model.catalog;

import javax.persistence.*;

/**
 * Класс - справочник "Производитель".
 * У каждого напитка свой производитель, наприер: Lipton, Jacobs и т.д.
 */

@Entity
@Table(name = "manufacturer")
public class Manufacturer extends GeneralCatalog {
}