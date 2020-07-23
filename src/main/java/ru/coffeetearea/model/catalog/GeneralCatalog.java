package ru.coffeetearea.model.catalog;

/**
 * Родительский абстрактный класс для всех справочников.
 * Общие поля справочников вынесены сюда.
 * Стратегия наследования @MappedSuperClass
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class GeneralCatalog {

    protected  @Id
    @GeneratedValue
    Long id;

    @Transient // ЭТО ВРЕМЕННО! ПОКА НЕ РАЗБЕРУСЬ, КАК ПОСТУПИТЬ С ОШИБКОЙ!!!!!
    protected String name;

    protected boolean isDeleted;
}