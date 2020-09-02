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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
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