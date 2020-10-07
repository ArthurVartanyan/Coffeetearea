package ru.coffeetearea.model.catalog;

import javax.persistence.*;

/**
 * Класс - справочник "Тип чая".
 * Чай может в незаваренном виде быть в нескольких видах, например: листвой, пакетированый и т.д.
 */

@Entity
@Table(name = "tea_type")
public class TeaType extends GeneralCatalog{
}