package ru.coffeetearea.model.catalog;

import javax.persistence.*;

/**
 * Класс - справочник "Упаковка".
 * Каждый напиток может иметь свой тип упаковки, например: Стеклянная банка, пакет, вакуумная упаковка и т.д.
 */

@Entity
@Table(name = "packaging")
public class Packaging extends GeneralCatalog {
}