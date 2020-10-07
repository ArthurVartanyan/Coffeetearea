package ru.coffeetearea.model.catalog;

import javax.persistence.*;

/**
 * Класс - справочник "Прожарка" для кофе.
 * Прожарки могут быть разными, в основном по степени от 1 до ...
 * Прожарка в БД хранится в строковом виде, то есть String name = "1".
 */

@Entity
@Table(name = "roasting")
public class Roasting extends GeneralCatalog{
}