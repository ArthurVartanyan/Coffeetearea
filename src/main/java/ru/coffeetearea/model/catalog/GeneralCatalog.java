package ru.coffeetearea.model.catalog;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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