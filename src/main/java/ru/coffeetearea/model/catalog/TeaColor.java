package ru.coffeetearea.model.catalog;

import javax.persistence.*;

/**
 * Класс - справочник "Цвет чая".
 * Чай имеет свой цвет, например: черный, зеленый и т.д.
 */

@Entity
@Table(name = "tea_color")
public class TeaColor extends GeneralCatalog{
}