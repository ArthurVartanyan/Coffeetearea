package ru.coffeetearea.model.catalog;

/**
 * Родительский абстрактный класс для всех справочников.
 * Общие поля справочников вынесены сюда.
 * Стратегия наследования InheritanceType.JOINED
 */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class GeneralCatalog {

    public @Id
    @GeneratedValue
    Long id;

    protected String name;

    protected boolean isDeleted;
}