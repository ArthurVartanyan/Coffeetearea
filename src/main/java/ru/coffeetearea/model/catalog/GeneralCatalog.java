package ru.coffeetearea.model.catalog;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Родительский абстрактный класс для всех справочников.
 * Общие поля справочников вынесены сюда.
 * Стратегия наследования @MappedSuperClass
 */

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class GeneralCatalog {

    @Id
    @GeneratedValue
    protected Long id;

    /**
     * Название объекта каталога
     */
    protected String name;

    /**
     * Флаг - удален или нет
     */
    protected boolean isDeleted;
}