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

    protected  @Id
    @GeneratedValue
    Long id;

    protected String name;

    protected boolean isDeleted;
}