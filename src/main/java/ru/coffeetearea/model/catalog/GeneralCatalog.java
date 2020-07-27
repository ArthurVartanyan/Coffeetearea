package ru.coffeetearea.model.catalog;

import lombok.Data;

import javax.persistence.*;

/**
 * Родительский абстрактный класс для всех справочников.
 * Общие поля справочников вынесены сюда.
 * Стратегия наследования @MappedSuperClass
 */

@Data
@MappedSuperclass
public abstract class GeneralCatalog {

    protected  @Id
    @GeneratedValue
    Long id;

    protected String name;

    protected boolean isDeleted;
}